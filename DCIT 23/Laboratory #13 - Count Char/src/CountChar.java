public class CountChar {
    public static void main(String[] args) {

        String str = "www.oracle.com";

        int max = str.length();
        int count = 0;

        for(int i = 0; i < max; i++) if(str.split("")[i].equals("w")) count++;
        
        System.out.println("Counting w : " + count);
    }
}