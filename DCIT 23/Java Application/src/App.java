/*
    Author: Bernard Sapida
*/
public class App {
    public static void main(String[] args) throws Exception {
        Numbers[] numbers_name = Numbers.values();
        Colors[] colors = Colors.values();
        for(int i = 0; i < colors.length; i++){
            System.out.println(colors[i].getColorAsInteger() + ": " + numbers_name[i] + " ("+colors[i]+")");
        }
    }
    public static enum Numbers { One, Two, Three, Four, Five }
    public static enum Colors { 
        RED(1), BLUE(2), GREEN(3), VIOLET(4), SCARLET(5);

        private final int color_number;

        Colors(int color_number){
            this.color_number = color_number;
        }

        public int getColorAsInteger(){
            return color_number;
        }

        public static Colors getColorAsName(int number){
            for(Colors color: Colors.values()){
                if(number == color.getColorAsInteger()){
                    return color;
                }
            }
            return null;
        }
    }
}
