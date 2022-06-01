import java.io.IOException;

public class TestClass {
    /**
     * It clears the terminal, creates a new Student object, and then loops through the
     * displayInformation() function three times
     */
    public static void main(String[] args) throws Exception {
        clearTerminal();

        Student student = new Student();

        System.out.println("====================================================");
        for(int i = 0; i < 3; i++) {
            student.displayInformation(i);
            System.out.println("====================================================");
        }
    }

    /**
     * It clears the terminal screen
     */
    public static void clearTerminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
