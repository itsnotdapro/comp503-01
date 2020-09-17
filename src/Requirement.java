package src;

/** Holds a requirement for a student to be certified in the TechnicalSchool
* @author 19076935 */
public class Requirement {
    private Level level;
    private int count;
    private ModuleTypeRequirement[] types;

    /** Constructor method for all internal class variables
    * @param moduleTypes An array of ModuleTypes, that are needed for this requirement to pass.
    *                    ModuleType.withAmountNeeded(count) can be used for a module that must
    *                    have several passing grades to meet the requirement
    * @param count The amount of courses that need to be passed to meet the requirements
    * @param level The level that the courses must be in to pass the requirement
    * @author 19076935 */
    public Requirement(ModuleTypeRequirement[] moduleTypes,  int count, Level level) {
        this.level = level;
        this.count = count;
        this.types = moduleTypes;
    }

    /** Constructor method for class variables, that accepts all levels of ModuleTypes
    * @param moduleTypes An array of ModuleTypes, that are needed for this requirement to pass.
    *                    ModuleType.withAmountNeeded(count) can be used for a module that must
    *                    have several passing grades to meet the requirement
    * @param count The amount of courses that need to be passed to meet the requirement
    * @author 19076935 */
    public Requirement(ModuleTypeRequirement[] moduleTypes,  int count) {
        this.count = count;
        this.types = moduleTypes;
        this.level = null;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //// **                                                                     ** ////
    //// ** This method below is probably not the most efficient solution, but  ** ////
    //// **         damn if it doesn't make implementation way easier           ** ////
    //// **                                                                     ** ////
    //// **      Effectively, what it's doing is first iterating over the       ** ////
    //// **  ModuleTypes that are needed for the requirement, then it iterates  ** ////
    //// ** over the results of the student for each ModuleType. The reason it  ** ////
    //// **    does this is to check, for each ModuleType, if the student has   ** ////
    //// **  passed enough of that specified ModuleType, which is determined by ** ////
    //// **    the ModuleType.withAmountNeeded method. This means a specific    ** ////
    //// **  ModuleType can have it's own amount of passes required, as opposed ** ////
    //// **                  to the generic number for a Level.                 ** ////
    //// **                                                                     ** ////
    //// **            In each loop, if the Result is all three of:             ** ////
    //// ** - A passing grade                                                   ** ////
    //// ** - The correct ModuleType                                            ** ////
    //// ** - The correct Level (this requirement is passed if                  ** ////
    //// **   the Requirement is constructed with no Level)                     ** ////
    //// **                                                                     ** ////
    //// **      Both count ints will be incremented, and the result will be    ** ////
    //// **  removed from the array. For each ModuleType, the ModuleType count  ** ////
    //// **  is check to see if it is large enough for the ModuleType's amount  ** ////
    //// **   needed. If not specified, this step is skipped.At the end of all  ** ////
    //// **   the loops, the total results that passed is checked against the   ** ////
    //// **  count specified in the constructor. If any of these checks fails,  ** ////
    //// **  the method returns false. If they all pass, then the student must  ** ////
    //// **     have met all the requirements, so the method returns true       ** ////
    //// **                                                                     ** ////
    ///////////////////////////////////////////////////////////////////////////////////

    // TODO : Wake up tomorrow and realise that this method doesn't make any sense
    /** Algorithm to determine whether or not the requirement specified in the constructor has been met by
    * a specified student
    * @param results The results of the student being tested
    * @return True if the requirement is met, false if not
    * @author 19076935 */
    public boolean passes(Result[] results) {
        int resultsPassed = 0; // Holds how many results have met the requirement, IN TOTAL
        for (ModuleTypeRequirement type : types) {
            int moduleCount = 0; // Holds how many results of THIS SPECIFIC MODULETYPE in the loop
                                 // have met the requirements
            for (Result result : results) {
                // Damn that's one THICC condition
                if (result.getModule().getType() == type.getType() && (
                    result.getModule().getLevel() == level || level == null) &&
                    result.getGrade().isPass()) {

                    moduleCount++; resultsPassed++; // Increment the counters
                    results = removeElementFromArray(results, result); // Remove the result from the array so we don't
                                                                               // check it twice
                }
            }
            // If there is a need for more than one of a specific type, and amount provided is less than
            // needed, then the student isn't certified, so we can safely return false here
            if (type.getAmountNeeded() > 0 && moduleCount < type.getAmountNeeded()) { return false; }
        }

        if (resultsPassed < count) { return false; }
        return true;
    }

    /** Takes a given Result[] array, and returns an array with the specified object removed
     * @param array The array to edit
     * @param object The object to remove
     * @return The edited array
     * @author 19076935 */
    private static Result[] removeElementFromArray(Result[] array, Result object) {
        Result[] output = new Result[array.length - 1];
        int i = 0;
        for (Result result : array) {
            if (result != object) {
                output[i] = result;
                i++;
            }
        }
        return output;
    }
}


