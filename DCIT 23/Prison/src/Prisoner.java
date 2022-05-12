public class Prisoner {
    public String name; 
    public double height;
    public int sentence;

    Prisoner(String name,double height,int sentence) {
        System.out.println(name);
        System.out.println(height);
        System.out.println(sentence);
    }

    public void think() {
        System.out.println("I'll have my revenge.");
    }
}

