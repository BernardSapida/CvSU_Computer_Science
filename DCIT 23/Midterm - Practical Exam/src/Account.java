public class Account {

    public int deposit (int user_balance, int deposit){

        if (deposit % 100 != 0) {
            System.out.println("Minimum deposit amount is 100 and should be muiltiples of 100!");
            System.out.println("Try Again!");
        }


        if (deposit < 100) {
            System.out.println("Unavailable to deposit due to your deposit amount is less than 100!");
            System.out.println("Try Again!");
        }
        
        
        if ((deposit % 100 == 0) && (deposit >= 100)) {
            user_balance = deposit + user_balance;
        }

        return user_balance;
    }

}
