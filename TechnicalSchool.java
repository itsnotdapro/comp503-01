package assignments.one;

/** Holder class that stores the different Modules offered by the schoolm
* @author 19076935 */
public class TechnicalSchool {
    private Module[] offerings;

    ////////////////////////////////////////////////////////////////////////////////////////
    //// **                                                                          ** ////
    //// **   Below is where the requirements for the TechnicalSchool Qualification  ** ////
    //// **   are held. The 4 here are from the spec, but more or less can be added  ** ////
    //// **                            or removed as needed                          ** ////
    //// **                                                                          ** ////
    //// **        The datatype is an array of Requirement classes, and each         ** ////
    //// **            Requirement class has three constructor arguments.            ** ////
    //// **                                                                          ** ////
    //// ** - moduleTypes, an array of ModuleTypeRequirement classes. Each           ** ////
    //// **   ModuleTypeRequirement is constructed with a ModuleType, and an         ** ////
    //// **   optional count, which is the amount of that ModuleType needed for the  ** ////
    //// **   requirement to pass. Leaving this argument will assume that only one   ** ////
    //// **   Module of that type is needed for the requirement                      ** ////
    //// **                                                                          ** ////
    //// ** - count, the amount of passing grades that need to be got in order for   ** ////
    //// **   the requirement to be met.                                             ** ////
    //// **                                                                          ** ////
    //// ** - level, the level that the results must be at in order to be considered ** ////
    //// **   for meeting the requirement. If is argument is not supplied, then the  ** ////
    //// **   requirement will accept all results at any level                       ** ////
    //// **                                                                          ** ////
    //// **     A requirement for 4 modules passed at level two, with at least 2     ** ////
    //// **               being taught would look like this in code:                 ** ////
    //// **                                                                          ** ////
    //// ** // The second array is where we specify the ModuleTypes needed           ** ////
    //// ** new Requirement(new ModuleTypeRequirement[]{                             ** ////
    //// **         // First is the one with the specified amount needed             ** ////
    //// **         new ModuleTypeRequirement(ModuleType.TAUGHT, 2)                  ** ////
    //// **                                                                          ** ////
    //// **         // The next three are because the requirement doesn't care       ** ////
    //// **         // if the last two are a type, so it needed to check for         ** ////
    //// **         // all types                                                     ** ////
    //// **         new ModuleTypeRequirement(ModuleType.SELF_STUDY),                ** ////
    //// **         new ModuleTypeRequirement(ModuleType.PROJECT),                   ** ////
    //// **         new ModuleTypeRequirement(ModuleType.CLIENT_PROJECT)},           ** ////
    //// **         4, Level.TWO // specifying the amount needed and level.          ** ///
    //// **                      // Level can be left blank if you're not            ** ////
    //// **                      // checking the Level for the requirement           ** ////
    //// **                                                                          ** ////
    //// **      Removing or adding an index from the requirements variable will     ** ////
    //// **       dynamically change what transcripts are considered qualifying      ** ////
    //// **              transcripts, and thus which student qualify                 ** ////
    //// **                                                                          ** ////
    ////////////////////////////////////////////////////////////////////////////////////////

    private final Requirement[] requirements = new Requirement[] {
            new Requirement(new ModuleTypeRequirement[]{
                    new ModuleTypeRequirement(ModuleType.SELF_STUDY),
                    new ModuleTypeRequirement(ModuleType.TAUGHT),
                    new ModuleTypeRequirement(ModuleType.CLIENT_PROJECT),
                    new ModuleTypeRequirement(ModuleType.PROJECT)},
                    3, Level.ONE),

            new Requirement(new ModuleTypeRequirement[]{
                    new ModuleTypeRequirement(ModuleType.SELF_STUDY, 2),
                    new ModuleTypeRequirement(ModuleType.TAUGHT),
                    new ModuleTypeRequirement(ModuleType.CLIENT_PROJECT),
                    new ModuleTypeRequirement(ModuleType.PROJECT)},
                    3, Level.TWO),

            new Requirement(new ModuleTypeRequirement[]{
                    new ModuleTypeRequirement(ModuleType.SELF_STUDY),
                    new ModuleTypeRequirement(ModuleType.TAUGHT, 2),
                    new ModuleTypeRequirement(ModuleType.CLIENT_PROJECT),
                    new ModuleTypeRequirement(ModuleType.PROJECT)},
                    4, Level.THREE),

            new Requirement(new ModuleTypeRequirement[]{
                    new ModuleTypeRequirement(ModuleType.CLIENT_PROJECT),
                    new ModuleTypeRequirement(ModuleType.PROJECT) },
                    1)
    };

    /** Constructor method that inits the offerings array
    * @author 19076935 */
    public TechnicalSchool() { this.offerings = TechnicalSchool.semesterOneModuleOfferings(); }

    // TODO : Import theses from a json file or a db or something because I hate that this is hardcoded
    /** Method used to generate the offering array, all semOne values hardcoded
    * @return An array of the Modules offered in semester one
    * @author 19076935 */
    private static Module[] semesterOneModuleOfferings() {
        Module[] semOne = new Module[13];
        semOne[0] = new Module(ModuleType.TAUGHT, "Programming", "PROG101", Level.ONE);
        semOne[1] = new Module(ModuleType.TAUGHT, "Statistics", "STAT102", Level.ONE);
        semOne[2] = new Module(ModuleType.TAUGHT, "Database Design", "DATA222", Level.TWO);
        semOne[3] = new Module(ModuleType.TAUGHT, "Object-Oriented Programming", "PROG202", Level.TWO);
        semOne[4] = new Module(ModuleType.TAUGHT, "Information Systems", "INSY313", Level.THREE);
        semOne[5] = new Module(ModuleType.TAUGHT, "Web Services", "WEBS332", Level.THREE);
        semOne[6] = new Module(ModuleType.SELF_STUDY, "Technology Applications", "TECH103", Level.ONE);
        semOne[7] = new Module(ModuleType.SELF_STUDY, "Theory of Computation", "THEO111", Level.ONE);
        semOne[8] = new Module(ModuleType.SELF_STUDY, "Model Checking", "MODC233", Level.TWO);
        semOne[9] = new Module(ModuleType.SELF_STUDY, "Topology", "TOPG233", Level.TWO);
        semOne[10] = new Module(ModuleType.SELF_STUDY, "Logic", "LOGI321", Level.THREE);
        semOne[11] = new Module(ModuleType.PROJECT, "Web App Dev", "PROJ399", Level.THREE);
        semOne[12] = new Module(ModuleType.CLIENT_PROJECT, "Great Code Company", "EXTO396", Level.THREE);
        return semOne;
    }

    /** Method to check whether or not a student's transcript is certification worthy in the TechnicalSchool
    * @param student The student being checked
    * @return True if certified, false it not certified
    * @author 19076935 */
    public boolean isCertified(Student student) {
        for (Requirement req : requirements) {
            if (!req.passes(student.getTranscripts())) { return false; }
        }
        return true;
    }

    //////////////////////////////
    //// ** Getter Methods ** ////
    //////////////////////////////

    /** Returns the array of Modules offered in semester one
    * @return Array of modules, each index a course offered in semester one
    * @author 19076935 */
    public Module[] getSemesterOfferings() { return offerings; }

    /** Returns the Module with the same code as the arg
    * @param code The code to search for
    * @return Module with code specified
    * @author 19076935 */
    public Module lookup(String code) {
        for (Module module : offerings) {
            if (module.getCode() == code) { return module; }
        }
        System.out.println("No module found with specified code");
        return null;
    }
}
