import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        
        System.out.print("\nEnter Rectangle Width: ");
        int rectangleWidth = in.nextInt();
        
        System.out.print("Enter Rectangle Height: ");
        int rectangleHeight = in.nextInt();

        createRectangle(rectangleWidth, rectangleHeight);
        
        System.out.print("\nEnter Triangle Size (NORMAL): ");
        int triangleSize = in.nextInt();
        createTriangle(triangleSize);

        // System.out.print("\nEnter Triangle Size (Horizontally Mirror): ");
        // int triangleXSize = in.nextInt();
        // createTriangleHorizontalFlipped(triangleXSize);

        // System.out.print("\nEnter Triangle Size (Vertically Mirror): ");
        // int triangleYSize = in.nextInt();
        // createTriangleVerticalFlipped(triangleYSize);

        in.close();
    }

    public static String createRectangle(int width, int height) {
        String rectangle = "";
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(y == 0 || y == height-1) {
                    System.out.print("#");
                } else {
                    if(x == 0 || x == width-1) {
                        System.out.print('#');
                    } else {
                        System.out.print(' ');
                    }
                }
            }
            System.out.println();
        }
        return rectangle;
    }

    public static void createTriangle(int size) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x <= y; x++) {
                if(x == 0 || x == y) {
                    System.out.print("*");
                } else {
                    if((y == size-1)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void createTriangleHorizontalFlipped(int size) {
        for (int heightSize = 0; heightSize < size; heightSize++) {
            for (int triangleSpace = size; triangleSpace > heightSize+1; triangleSpace--) System.out.print(" ");
            for (int widthSize = 0; widthSize <= heightSize; widthSize++) {
                if(widthSize == 0 || widthSize == heightSize) System.out.print("*");
                else System.out.print((heightSize == size-1) ? "*" : " ");
            }
            System.out.println();
        }
    }
    
    public static void createTriangleVerticalFlipped(int size) {
        for (int heightSize = size; heightSize > 0; heightSize--) {
            for (int triangleSpace = size; triangleSpace > heightSize; triangleSpace--) System.out.print(" ");
            for (int widthSize = heightSize; widthSize > 0; widthSize--) {
                if(widthSize == 0 || widthSize == heightSize) System.out.print("*");
                else System.out.print((heightSize == size || widthSize == 1) ? "*" : " ");
            }
            System.out.println();
        }
    }
}
