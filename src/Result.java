package src;

/** Stores the resultant grade for a module
* @author 19076935 */
public class Result {
    private Module module;
    private Grade grade;

    /** Constructor method for all internal class variables
    * @param module The module who's grade is being evaluated
    * @param grade The grade received in that module
    * @author 19076935 */
    public Result(Module module, Grade grade) {
        this.module = module;
        this.grade = grade;
    }

    /** Returns a string representation of the Result class
    * @return String based on object variables
    * @author 19076935 */
    @Override
    public String toString() { return grade + " in " + module.getTitle();  }

    /////////////////////////////////////////
    //// ** Getter and Setter Methods ** ////
    /////////////////////////////////////////

    /** Gets the stored Module object
    * @return Module stored in object
    * @author 19086935 */
    public Module getModule() { return module; }

    /** Gets the stored Grade Object
    * @return Grade stored in object
    * @author 19076935 */
    public Grade getGrade() { return grade; }

    /** Sets the currently stored Module
    * @param module Module to store in the object
    * @author 19076935 */
    public void setModule(Module module) { this.module = module; }

    /** Sets the currently stored Grade
    * @param grade Grade to store in the object
    * @author 19076935 */
    public void setGrade(Grade grade) { this.grade = grade; }

}
