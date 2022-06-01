public class Student extends Teacher {
    protected final String[] studentsName = {"Bernard Sapida", "Christian Arby Camama", "Zymon Clark Mendoza"};
    protected final String[] studentsNo = {"202102231", "202101567", "202102081"};
    protected final String[] enrolledSubject = {"Software Engineering", "Data Structure and Algorithm", "Discrete Structure"};
    
    /**
     * It displays the information of the student
     * 
     * @param i the index of the array
     */
    public void displayInformation(int i) {
        super.displayInformation(i);
        
        System.out.println("Student No.: " + studentsNo[i]);
        System.out.println("Student Name: " + studentsName[i]);
        System.out.println("Enrolled Subject: " + enrolledSubject[i] + "\n");
    }
}