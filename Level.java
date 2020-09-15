package assignments.one;

/** The level of a course
* @author 19076935 */
public enum Level {
    ONE (1, "one"),
    TWO (2, "two"),
    THREE (3, "three");

    public final int value;
    private final String string;

    /** Constructor method for all internal enum variables
    * @param value The integer representation of the level
    * @author 19076935 */
    private Level(int value, String string) {
        this.value = value;
        this.string = string;
    }

    /** Returns the Level enum based on an input integer
    * @param level the level as an int
    * @return The Level enum of the same value, defaults to Level.ONE if int is invalid
    * @author 19076935 */
    public static Level intToLevel(int level) {
        for (Level lv : Level.values()) { // check each possible value of a Level based on int, return matching one
            if (lv.value == level) { return lv; }
        }
        // In theory the code shouldn't really be reaching here, but juuuust in case we gotta default value
        return Level.ONE;
    }

    // I'm sure this method can be made better, given that the characters are the same as the
    // enum names just different case, but this works and it's not too horrible so we'll keep it for now
    /** Returns a String representation of the Level, that's not in all caps
    * @return A String based on the level's value
    * @author 19076935 */
    @Override
    public String toString() {
        // Originally I had these strings stored in an array, hur dur you can just have them as an enum var
        // god I'm really stupid
        return this.string;

        /////////////////////////////////////////////////////////////////
        //// ** For reference, this is what it used to look like, ** ////
        //// **         when I did it really stupidly             ** ////
        /////////////////////////////////////////////////////////////////

        // String[] representation = {"One", "Two", "Three"};
        // return representation[this.value];

        //////////////////////////////////////////////////////////////////
        //// ** Don't think it's that bad? It get's so much worse, ** ////
        //// ** because before I had this horrible implementation  ** ////
        //////////////////////////////////////////////////////////////////

        // String[] representation = {"One", "Two", "Three"};
        // for (Level level : Level.values()) {
        //     if (level == this) { return representation[this.value];
        // }

        /////////////////////////////////////////////////////////////////
        //// ** That for loop isn't even doing anything! What the ** ////
        //// **    actual hell was my primate brain thinking?     ** ////
        //// **                                                   ** ////
        //// **  I even had it with int i = 0... at one point to  ** ////
        //// **                 make it extra bad                 ** ////
        /////////////////////////////////////////////////////////////////
    }
}
