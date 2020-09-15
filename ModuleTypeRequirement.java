package assignments.one;

/** A class used for the Requirement checking of the TechnicalSchool certification. As a requirement
* might need x number of specific ModuleTypes passed, as opposed to the generic number passed at a given level,
* this class adds support for ModuleType enums with count variables. Usage in code is outlined in the
* TechnicalSchool class, which is where they are used.
 */
public class ModuleTypeRequirement {
    private ModuleType type;
    private int count;

    /** Constructor method for all internal class variables
    * @param type The type of Module for the requirement
    * @param count The amount of this type needed for the requirement to be met
    * @author 19076935 */
    public ModuleTypeRequirement(ModuleType type, int count) {
        this.type = type;
        this.count = count;
    }

    /** Constructor method for initialising with default count, i.e. not checking the count for this module
    * @param type The type of Module for the requirement
    * @author 19076935 */
    public ModuleTypeRequirement(ModuleType type) { this.type = type; }

    /** Returns a String representation of the ModuleTypeRequirement
    * @return String based on object variables
    * @author 19076935 */
    @Override
    public String toString() { return "Requirement Module: " + type.toString() + " with " + count + " needed"; }

    /** Gets the amount of ModuleTypes needed for the requirement
    * @return A count of the ModuleTypes needs
    * @author 19076935 */
    public int getAmountNeeded() { return count; }

    /** Gets the type needed for the requirement
    * @return The type needed
    * @author 19076935 */
    public ModuleType getType() {return type; }

    /** Sets the amount of ModuleTypes needed for the requirement
    * @param count The amount of the type needed
    * @return True if amountNeeded is set, false if not (i.e. count was not greater than 0)
    * @author 19076935 */
    public boolean setAmountNeeded(int count) {
        if (count <= 0) {
            this.count = count;
            return true;
        }
        System.out.println("Amount needed cannot be <= 0");
        return false;
    }

    /** Sets the type of module needed for the requirement
    * @param type The type needed for the requirement
    * @author 19076935 */
    public void setType(ModuleType type) { this.type = type; }
}
