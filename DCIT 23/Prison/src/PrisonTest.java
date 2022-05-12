public class PrisonTest {
    public static void main(String[] args) throws Exception {
        Prisoner bubba = new Prisoner("bubba", 2.08, 4);
        Prisoner twitch = new Prisoner("twitch", 2.08, 4);

        bubba.name = "bubba";
        bubba.height = 2.08;
        bubba.sentence = 4;

        bubba.name = "twitch";
        bubba.height = 2.08;
        bubba.sentence = 4;

        System.out.println(bubba.name + " " + twitch.name);
    }
}