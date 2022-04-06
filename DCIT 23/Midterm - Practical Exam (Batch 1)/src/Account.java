public class Account {
    Banking bank = new Banking();

    public void withdrawal(int initialBalance, int toWithdraw){
        if(toWithdraw > initialBalance) {
            System.out.println("Error: Unavailable to withdraw since withdrawal amount is higher than initial balance.");
            Banking.isSuccess = false;
        }
        if(toWithdraw % 100 != 0) {
            System.out.println("Error: Minimum withdrawal amount is 100 and should be muiltiples of 100.");
            Banking.isSuccess = false;
        }

        if((toWithdraw <= initialBalance) && Banking.isSuccess) {
            Banking.balance -= toWithdraw;
        }
    }

}