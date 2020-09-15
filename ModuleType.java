package assignments.one;

/** The type of study that a course offers, based on how the learning takes place
* @author 19076935 */
public enum ModuleType {
    SELF_STUDY ("self taught"),
    TAUGHT ("taught"),
    PROJECT ("a project"),
    CLIENT_PROJECT ("a client Project");

    private final String string;

    /** Constuctor method for all internal enum variables
    * @param string the String representation of the ModuleType
    * @author 19076935 */
    private ModuleType(String string) { this.string = string; }

    /** Returns a String representation of the ModuleType
    * @return A String based on the type's index
    * @author 19076935 */
    @Override
    public String toString() { return this.string; }
}
