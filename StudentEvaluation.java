package assignments.one;

/** Main application class for package, stores the user runnable code
* @author 19076935 */
public class StudentEvaluation {
    private static TechnicalSchool techSchool = new TechnicalSchool();
    public static void main (String[] args) {
        Student robin = robin();
        System.out.println(robin + "\n");

        System.out.println("Robin is failing on only having two modules at level one," +
        "and only having three modules at level three. If we add a module at level one:\n");
        robin.addResultToTranscript(techSchool.lookup("STAT102"), Grade.BPLUS);
        System.out.println(robin + "\n");
        System.out.println("He still fails. But if we add a result at level three as well:\n");
        robin.addResultToTranscript(techSchool.lookup("LOGI321"), Grade.CPLUS);
        System.out.println(robin + "\n");
        System.out.println("He is now certified.\n\n\n");

        Student john = john();
        System.out.println(john + "\n");

        System.out.println("John is a student who failed Programming. Oh no! That means he had to take it again," +
        "and this time he did much better, and scored himself a B+.\n");
        john.addResultToTranscript(techSchool.lookup("PROG101"), Grade.BPLUS);
        System.out.println(john + "\n");

        System.out.println("But, if for some reason he chooses to take the class a third time, and gets a worse grade," +
        "he won't be penlised for it. The highest grade is always kept\n");
        john.addResultToTranscript(techSchool.lookup("PROG101"), Grade.BMINUS);
        System.out.println(john + "\n\n\n");

        Student steven = steven();
        System.out.println(steven);
        System.out.println("\nSteven has not passed his project module. That means he's gotta take it again. If he passes it this time:\n");

        steven.addResultToTranscript(techSchool.lookup("PROJ399"), Grade.B);
        System.out.println(steven);
        System.out.println("\nHe's now certified.");

        System.exit(200);
    }

    public static Student robin() {
        Student robin = new Student("Robin");
        robin.addResultToTranscript(techSchool.lookup("PROG101"), Grade.C);
        robin.addResultToTranscript(techSchool.lookup("DATA222"), Grade.C);
        robin.addResultToTranscript(techSchool.lookup("INSY313"), Grade.CPLUS);
        robin.addResultToTranscript(techSchool.lookup("WEBS332"), Grade.CPLUS);
        robin.addResultToTranscript(techSchool.lookup("TECH103"), Grade.CPLUS);
        robin.addResultToTranscript(techSchool.lookup("MODC233"), Grade.CMINUS);
        robin.addResultToTranscript(techSchool.lookup("TOPG233"), Grade.CMINUS);
        robin.addResultToTranscript(techSchool.lookup("PROJ399"), Grade.APLUS);

        return robin;
    }

    public static Student kate() {
        Student kate = new Student("Kate");
        kate.addResultToTranscript(techSchool.lookup("PROG101"), Grade.APLUS);
        kate.addResultToTranscript(techSchool.lookup("STAT102"), Grade.AMINUS);
        kate.addResultToTranscript(techSchool.lookup("TECH103"), Grade.BPLUS);
        kate.addResultToTranscript(techSchool.lookup("MODC233"), Grade.A);
        kate.addResultToTranscript(techSchool.lookup("TOPG233"), Grade.C);
        kate.addResultToTranscript(techSchool.lookup("DATA222"), Grade.A);
        kate.addResultToTranscript(techSchool.lookup("INSY313"), Grade.BPLUS);
        kate.addResultToTranscript(techSchool.lookup("WEBS332"), Grade.AMINUS);
        kate.addResultToTranscript(techSchool.lookup("PROJ399"), Grade.B);
        kate.addResultToTranscript(techSchool.lookup("EXTO396"), Grade.B);

        return kate;
    }

    public static Student axel() {
        Student axel = new Student("Axel");
        axel.addResultToTranscript(techSchool.lookup("PROG101"), Grade.BPLUS);
        axel.addResultToTranscript(techSchool.lookup("STAT102"), Grade.C);
        axel.addResultToTranscript(techSchool.lookup("DATA222"), Grade.A);
        axel.addResultToTranscript(techSchool.lookup("INSY313"), Grade.AMINUS);
        axel.addResultToTranscript(techSchool.lookup("TECH103"), Grade.A);
        axel.addResultToTranscript(techSchool.lookup("MODC233"), Grade.B);
        axel.addResultToTranscript(techSchool.lookup("TOPG233"), Grade.B);
        axel.addResultToTranscript(techSchool.lookup("PROJ399"), Grade.CMINUS);
        axel.addResultToTranscript(techSchool.lookup("EXTO396"), Grade.C);

        return axel;
    }

    public static Student jim() {
        Student jim = new Student("Jim");
        jim.addResultToTranscript(techSchool.lookup("PROG101"), Grade.A);
        jim.addResultToTranscript(techSchool.lookup("STAT102"), Grade.BPLUS);
        jim.addResultToTranscript(techSchool.lookup("DATA222"), Grade.CPLUS);
        jim.addResultToTranscript(techSchool.lookup("PROG202"), Grade.C);
        jim.addResultToTranscript(techSchool.lookup("INSY313"), Grade.C);
        jim.addResultToTranscript(techSchool.lookup("WEBS332"), Grade.CPLUS);
        jim.addResultToTranscript(techSchool.lookup("TECH103"), Grade.CMINUS);
        jim.addResultToTranscript(techSchool.lookup("THEO111"), Grade.D);
        jim.addResultToTranscript(techSchool.lookup("MODC233"), Grade.APLUS);
        jim.addResultToTranscript(techSchool.lookup("TOPG233"), Grade.A);
        jim.addResultToTranscript(techSchool.lookup("LOGI321"), Grade.B);
        jim.addResultToTranscript(techSchool.lookup("PROJ399"), Grade.BMINUS);
        jim.addResultToTranscript(techSchool.lookup("EXTO396"), Grade.APLUS);

        return jim;
    }

    public static Student john() {
        Student john = new Student ("John");
        john.addResultToTranscript(techSchool.lookup("PROG101"), Grade.D);
        return john;
    }

    public static Student steven() {
        Student steven = new Student("Steven");
        steven.addResultToTranscript(techSchool.lookup("PROG101"), Grade.APLUS);
        steven.addResultToTranscript(techSchool.lookup("STAT102"), Grade.AMINUS);
        steven.addResultToTranscript(techSchool.lookup("TECH103"), Grade.BPLUS);
        steven.addResultToTranscript(techSchool.lookup("MODC233"), Grade.A);
        steven.addResultToTranscript(techSchool.lookup("TOPG233"), Grade.C);
        steven.addResultToTranscript(techSchool.lookup("DATA222"), Grade.A);
        steven.addResultToTranscript(techSchool.lookup("INSY313"), Grade.BPLUS);
        steven.addResultToTranscript(techSchool.lookup("WEBS332"), Grade.AMINUS);
        steven.addResultToTranscript(techSchool.lookup("PROJ399"), Grade.D);

        return steven;
    }
}
