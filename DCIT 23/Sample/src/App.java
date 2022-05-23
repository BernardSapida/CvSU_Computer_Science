import Test.Test;

public class App {
    public static void main(String[] args) throws Exception {
        Card card = new Card();

        card.setTicketBalance(10);

        card.getCardInfo();

        System.out.println(Test.name);
    }
}
