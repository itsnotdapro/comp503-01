package assignments.one;

/** Definition class of a school course, called modules
* @author 19076935 */
public class Module {
    private ModuleType type;
    private String title;
    private String code;
    private Level level;

    /** Constructor method for all internal class variables, with Level input for level
    * @param type The type of the module
    * @param title The title of the module
    * @param code The 7 character code of the module
    * @param level The level of the module
    * @author 19076935 */
    public Module (ModuleType type, String title, String code, Level level) {
        this.type = type;
        this.title = title;
        this.level = level;

        // Making sure they don't give dumb inputs
        if (!setCode(code)) {
            System.out.println("Invalid module code given, setting to default ####000");
            this.code = "####000";
        }
    }

    /** Constructor method for all internal class variables, with integer input for level
    * @param type The type of the module
    * @param title The title of the module
    * @param code The 7 character code of the module
    * @param level The level of the module
    * @author 19076935 */
    public Module (ModuleType type, String title, String code, int level) {
        this.type = type;
        this.title = title;

        // Making sure they don't give dumb inputs
        if (!setLevel(level)) { System.out.println("Invalid level given, attempting to set on module's code"); }
        if (!setCode(code)) {
            System.out.println("Invalid module code given, setting to default ####000");
            this.code = "####000";
        }
    }

    // Haha one line toString overrides go brrrrrrr
    /** Returns a String representation of the Module, based on it's internal vars
    * @return a String based on the class vars
    * @author 19076935 */
    @Override
    public String toString() { return title + " is a module with code: " + code + ", which is " + type + " at level " + level; }

    ///////////////////////////////////////////////////////////
    //// ** Welcome, to the wall of Getters and Setters ** ////
    ///////////////////////////////////////////////////////////

    ////////////////////
    // Getter methods //
    ////////////////////

    /** Returns the type of the module
    * @return Module's type
    * @author 19076935 */
    public ModuleType getType () { return type; }

    /** Returns the module's title
    * @return Module title
    * @author 19076935 */
    public String getTitle () { return title; }

    /** Returns the module's code
    * @return Module code
    * @author 19076935*/
    public String getCode () { return code; }

    /** Returns the level of the module
    * @return Module level
    * @author 19076935 */
    public Level getLevel () { return level; }

    ////////////////////
    // Setter methods //
    ////////////////////

    /** Sets the type of the module, does not returns as there is no invalid ModuleType enum
    * @param type The type to set the module to
    * @author 19076935 */
    public void setType(ModuleType type) { this.type = type; }

    /** Sets the title of the module, does not return as there is no invalid title;
    * @param title The updated title of the module
    * @author 19076935 */
    public void setTitle(String title) { this.title = title; }

    /** Sets the level of the module, does not return as there is not invalid Level enum
    * @param level The updated level of the module
    * @author 19076925 */
    public void setLevel(Level level) { this.level = level; }

    /** Sets the level of the module based on a given int
    * @param level The updated level of the module as an int
    * @return True if the value was set, false if value was not set (invalid input)
    * @author 19076925 */
    public boolean setLevel(int level) {
        if (level > 3) {
            System.out.println("Given level is too large, not set");
            return false;
        } else if (level < 1) {
            System.out.println("Given level is too small, not set");
            return false;
        }

        this.level = Level.intToLevel(level);
        return true;
    }

    /** Sets the value of the module's code. Will also update the level of the module based on the code's number
    * @param code The updated 7 character module code, first 4 letters, last 3 numbers
    * @return True if value was set, false if value was not set (invalid input)
    * @author 19076935 */
    public boolean setCode(String code) {
        if (code.length() == 7) {
            for (int i = 0 ; i < 4; i++) {
                if (!Character.isLetter(code.charAt(i))) {
                    System.out.println("One of the first 4 charaters was not a letter! Code of module not set!");
                    return false;
                }
            }
            for (int i = 4; i < 7; i++) {
                if (!Character.isDigit(code.charAt(i))) {
                    System.out.println("One of the last 3 charaters was not a letter! Code of module not set!");
                    return false;
                }
            }

            // if the code has made it here, the String is a valid module code
            this.code = code;

            setLevel(Integer.parseInt(("" + code.charAt(4)))); // Damn why are there 4 bracket at the end of this,
            return true;                                       // this is a spicy 4 layered index, just the way
        }                                                      // we like it.

        // If we ever get here for any other reason than the arg string is too short or long, something's messed up.
        System.out.println("Code not 7 characters, or something went wrong! Code of module not set!");
        return false;
    }


    ///////////////////////////////////////////////////////////////////////////////////
    //// ** And thus ends the too many lines of access methods, especially that ** ////
    //// **          last one damn that's way to much data validation           ** ////
    ///////////////////////////////////////////////////////////////////////////////////
}
