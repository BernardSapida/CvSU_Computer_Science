public class App {
    static int num = 5;
    enum Numbers { a, b, c, d, e };
    // static String[] names = {"Bernard", "Christina"};
    public static void main(String[] args) throws Exception {
        // Numbers[] numbers = Numbers.values();
        Color[] color = Color.values();
        System.out.println("Hello, Bernard Sapida!");
        System.out.println(Color.RED.getColorAsInt());
        Color.convertIntToColor(10);
        for(Color colors: color){
            System.out.println(colors);
        }
    }

    public enum Color {
        RED(10), 
        BLUE(20), 
        GREEN(30), 
        YELLOW(40), 
        BLACK(50);
         
        private final int color;
        
        Color(int color) {
            this.color = color;
        }

        public int getColorAsInt() {
            return color;
        }
        
        public static Color convertIntToColor(int iColor) {
            for (Color color : Color.values()) {
                if (color.getColorAsInt() == iColor) {
                    return color;
                }
            }
            return null;
        }
     
    }
}
