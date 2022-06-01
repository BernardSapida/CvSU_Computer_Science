public abstract class Classroom extends Campus {
    protected final String building = "DIT";
    protected final String[] room = {"CCL 3", "CCL 12", "CCL 20"};
    protected final String[] subjectTaught = {"Software Engineering", "Data Structure and Algorithm", "Discrete Structure"};

    /**
     * This function displays the information of the teacher
     * 
     * @param i the index of the array
     */
    public void displayInformation(int i) {
        super.displayInformation();

        System.out.println("Building: " + building);
        System.out.println("Room: " + room[i]);
        System.out.println("Subject Taught: " + subjectTaught[i] + "\n");
    }
}
