public class JavaLoops {
    public static void main(String[] args) throws Exception {
        int sum = 1;
        int temp = 1;
        // num:  1+2+4+7+11+16+22 = 63 (Sum of all)
        //        ▼ ▼ ▼ ▼  ▼  ▼  
        // diff:  1 2 3 4  5  6

        for(int diff = 1; diff <= 6; diff++){
            temp += diff;
            // Loop #: temp(temp+diff)
            // Case 1: temp(2)         = temp(1)  + diff (1) 
            // Case 2: temp(4)         = temp(2)  + diff (2) 
            // Case 3: temp(7)         = temp(4)  + diff (3) 
            // Case 4: temp(11)        = temp(7)  + diff (4) 
            // Case 5: temp(16)        = temp(11) + diff (5) 
            // Case 6: temp(22)        = temp(16) + diff (6) 

            sum += temp;
            // Loop #: sum(sum+temp)
            // Case 1: sum(3)        = sum(1)  + temp(2)
            // Case 2: sum(7)        = sum(3)  + temp(4)
            // Case 3: sum(14)       = sum(7)  + temp(7)
            // Case 4: sum(25)       = sum(14) + temp(11)
            // Case 5: sum(41)       = sum(25) + temp(16)
            // Case 6: sum(63)       = sum(41) + temp(22)
        }
        System.out.println(sum); // 63
    }
}

/*
    What is Variable?
    Numeric Data Types
    Textual Data Types
    Converting Between Data Types
    Keyboard Input
    Creating a Class
    What is a Method?
    Instantiating Objects
    The Import Declaration and Packages
    The String Class, Random Class, Math Class
    Boolean Expression & Conditional Execution (If/Else Constructs)
    Switch Statements
    ? For Loop, While Loop, Recursion Loop
    ? Using Break & Continue in Loop
*/