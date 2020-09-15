package assignments.one;

/** Stores the data for a student, such as their name, and their transcript
* @author 19076935 */
public class Student {
    private String name; // Ideally this'd be a public final, because who changes their name and it's easier to
                         // access, but UML says it's a private normal
    private final int MAX_TRANSCRIPT_LENGTH = 20;
    private int nResults;
    private Result[] transcripts;

    /** Constructor method for name of student, all other variables are handled automatically
    * @param name The name of the student
    * @author 19076935 */
    public Student(String name) {
        this.name = name;
        transcripts = new Result[MAX_TRANSCRIPT_LENGTH];
    }

    /** Adds a Result to the transcript, generated by input args
    * @param module The module for the result
    * @param grade The grade received in the module
    * @author 19076935 */
    public void addResultToTranscript(Module module, Grade grade) {
        Result addedResult = new Result(module, grade);
        if (nResults < MAX_TRANSCRIPT_LENGTH) {
            int i = 0;
            for (Result result : getTranscripts()) { // Checking each result to see if the student has taken the
                                                      // class before
                // This totally awful garbage conditional statement is needed because Java doesn't have a way of taking
                // 2 objects and comparing all their values, and this is probably easier than overriding the .equals method
                if (result.getModule().getCode().equals(module.getCode())) {
                    if (result.getGrade().getLow() >= grade.getLow()) {
                        System.out.println("Result already exists, Result not added");
                        return;
                    } else if (result.getGrade().getLow() < grade.getLow()) {
                        transcripts[i] = addedResult; // Update the result with a new grade
                        return;
                    }
                } i++;
            }
            transcripts[nResults] = addedResult;
            nResults++;
            return;
        }
        System.out.println("Transcript already full! Result not added.");
    }

    /** Returns the students transcripts
    * @return An array of Results, equal in length to the amount of non null results in transcripts
    * @author 19076935 */
    public Result[] getTranscripts() {
        Result[] output = new Result[nResults];
        // Making sure only the non null items are added
        for (int i = 0; i < nResults; i++) { output[i] = transcripts[i]; }
        return output;
    }

    /** Returns the name of the student for printing
    * @return Student name as string
    * @author 19076935 */
    @Override
    public String toString() {
        String output = name + "'s Transcript: \n";
        // For each result in the transcript, add it to the result and tab it once
        for (Result result : getTranscripts()) { output += "\t- " + result + "\n"; }
        // Ternary to add "not" in front of "certified" if the student is not certified
        output += name + " is" + (new TechnicalSchool().isCertified(this) ? " " : " not ") + "certified";
        return output;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //// **                         Getters and Setters                          ** ////
    //// **                                                                      ** ////
    //// ** None of these where specified in the spec except in the UML, they're ** ////
    //// **        not used and frankly some of them shouldn't be used but       ** ////
    //// **                     we'll chuck them in anyway                       ** ////
    ////////////////////////////////////////////////////////////////////////////////////

    /** Returns the number of results in the student's transcript
     * @return Number of results in transcript
     * @author 19076935 */
    public int getNResults() { return nResults; }

    /** Returns the name of the student
    * @return Student name as string
    * @author 19076935 */
    public String getName() { return name; }

    /** Sets the transcript of the student
    * @param results An array of results to set as the transcript
    * @author 19076935 */
    public void setTranscripts(Result[] results) { this.transcripts = results; }

    /** Sets the transcript length of the student
    * @param n Number to set as the transcript length
    * @author 19076935 */
    public void setNResults(int n) { if (n <= MAX_TRANSCRIPT_LENGTH && n > 0) { this.nResults = n; } }

    /** Sets the name of the student
    * @param name Name of the student
    * @author 19076935 */
    public void setName(String name) {this.name = name; }


}
