public class TernaryOperator {

    public static void main(String[] args) {
        int x = 4, y = 9;
        if (y / x < 3) {
            x += y;
        } else {
            x *= y;
        }
        System.out.println("After if stmt, x = " + x); // After if stmt, x = 13
        
        // Use a ternary operator to perform the same logic as above.
        x = (y / x < 3) ? (x += y) : (x *= y);
        System.out.println("After if stmt, x = " + x); // After if stmt, x = 22

        /*
            Note:
            • First If Else statement generate x = 13
            Solution:
              since 9/4 = 2.25
              2.25 < 3 => x += y (4 + 9 = 13)

            • Ternary Operator gererate x = 22
            Solution:
              since 9/13 = 0.6923
              0.6923 < 3 => x += y (13 + 9 = 22)
        */
    }
}