/*
    Author: Bernard Sapida
*/
public class App {
    static int num = 5;
    enum Numbers { a, b, c, d, e };
    static String[] names = {"Bernard", "Sapida"};
    public static void main(String[] args) throws Exception {
        // Numbers[] numbers = Numbers.values();
        Color[] color = Color.values();
        Color.convertIntToColor(10);
        System.out.println("Available Colors: ");
        for(Color colors: color){
            System.out.println(Color.convertIntToColor(colors.getColorAsInt()) + " " + colors.getColorAsInt());
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
