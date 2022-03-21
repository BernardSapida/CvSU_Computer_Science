public class ExchangeXY {
    public static void main(String[] args) throws Exception {
        // Swap Part. 1
        int x = 14, y = 7, z;
        z = (x+1)*(y+1);
        x = (z / (x+1)) - 1;
        y = (z / (y+1)) - 1;
        
        // Swap Part. 2
        // int x = 14, y = 7, z;
        // z = x + y;
        // x = z - x;
        // y = z - y;

        System.out.println("x: " + x + "\n" + "y: " + y);
    }
}