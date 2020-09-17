package src;

/** Holds all values of grades and their boundaries.
* @author 19076935 */
public enum Grade {

    APLUS (100, 90),
    A (90, 85),
    AMINUS (85, 80),
    BPLUS (80, 75),
    B (75, 70),
    BMINUS(70, 65),
    CPLUS(65, 60),
    C (60, 55),
    CMINUS (55, 50),
    D (50, 0);

    private int high;
    private int low;
    private boolean pass;

    /** Constructor method for all internal enum variables
    * @param upper Upper limit of the grade, which student's grade must be less than
    * @param lower Lower limit of the grade, which student's grade must be greater than or equal to
    * @author 19076935 */
    private Grade(int upper, int lower) {
        this.high = upper;
        this.low = lower;

        if (this.low < 50) { this.pass = false; }
        else { this.pass = true; }
    }

    /** Returns true or false based on whether or not the grade is a passing grade
    * @author 19076935
    * @return Value of this.pass, determined on enum init */
    public boolean isPass() { return pass; }

    /** Returns the string representation of the grade, i.e. BPLUS becomes B+
    * @return Name of grade with +- characters
    * @author 19076935 */
    @Override
    public String toString() {
        String output = "" + super.toString().charAt(0); // super identifier calls the unoverrided method, otherwise this
                                                         // would call itself over and over again, never getting a value

        // Checking based on the first character, because String.substring() didn't work
        if (super.toString().length() > 1) {
            if (super.toString().charAt(1) == 'P') { output += "+"; }
            if (super.toString().charAt(1) == 'M') { output += "-"; }
        }

        return output;
    }

    /** Returns the high boundary of the grade
    * @return The high boundary of the grade
    * @author 19076935 */
    public int getHigh() { return high; }

    /** Returns the low boundary of the grade
    * @return The low boundary of the grade
    * @author 19076935 */
    public int getLow() { return low; }
}
