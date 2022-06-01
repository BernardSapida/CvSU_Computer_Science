public class Teacher extends Classroom {
    protected final String[] professorName = {"Ms. Julie Ann Lontoc", "Sr. Joshua Ricarte", "Mr. Aaron Paul Hernandez"};

    /**
     * This function displays the information of the professor
     * 
     * @param i the index of the array
     */
    public void displayInformation(int i) {
        super.displayInformation(i);

        System.out.println("Professor Name: " + professorName[i]);
        System.out.println("Subject Taught: " + subjectTaught[i] + "\n");
    }
}