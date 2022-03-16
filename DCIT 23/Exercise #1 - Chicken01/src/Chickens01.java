public class Chickens01 {
    public static void main(String[] args) throws Exception {
        // variable declaration
        int chickenCount_1 = 3,
            eggsPerChicken_1 = 5,
            chickenCount_2 = 8,
            eggsPerChicken_2 = 4;

        // Instantiating the FarmerBrown Class
        FarmerBrown farmerBrown = new FarmerBrown();

        // Setters and Getters for first scenario
        farmerBrown.setTotalEggs(chickenCount_1, eggsPerChicken_1);
        farmerBrown.getTotalEggs();

        // Setters and Getters for second scenario
        farmerBrown.setTotalEggs(chickenCount_2, eggsPerChicken_2);
        farmerBrown.getTotalEggs();
    }
}

class FarmerBrown {
    // Properties of FarmerBrown
    private int monday, tuesday, wednesday, chickenCount, eggsPerChicken;
    private static int count;

    // Behavior of FarmerBrown
    // Setter Method for Total Eggs
    public void setTotalEggs(int chickenCount, int eggsPerChicken){
        count++;
        this.chickenCount = chickenCount;
        this.eggsPerChicken = eggsPerChicken;
    }

    // Getter Method for Total Eggs
    public void getTotalEggs(){
        System.out.println("\nScenario #" + count);
        this.monday = this.chickenCount * this.eggsPerChicken;
        System.out.println("Monday: " + monday);
        this.tuesday = (this.chickenCount += 1) * this.eggsPerChicken;
        System.out.println("Tuesday: " + tuesday);
        this.wednesday = (this.chickenCount /= 2) * this.eggsPerChicken;
        System.out.println("Wednesday: " + wednesday);
        System.out.println("Total Eggs: " + (int)(monday + tuesday + wednesday));
        System.out.println();
    }
}