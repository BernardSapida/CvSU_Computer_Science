public class ShoppingCart {
    public static void main(String[] args) {
        String custName = "Mary Smith";
        String itemDesc = "Shirt";
        double price = 21.99;
        int quantity = 1;
        double tax = 1.04;
        double total;
        String message = custName+" wants to purchase "+quantity+" "+itemDesc;
        
        // Calculating total cost
        total = (price*quantity)*tax;
        
        // Declare outOfStock variable and initialize it.
        boolean outOfStock = false;
        
        // Test quantity and modify message if quantity > 1.
        // Singular: Mary Smith wants to purchase 1 shirt.
        // Plural: Mary Smith wants to purchase >1 shirts.
        if(quantity > 1) {
            itemDesc = "Shirts";
            message = custName+" wants to purchase "+quantity+" "+itemDesc;
        }
        
        // Test outOfStock and notify user in either case.
        // If quantity is 0 then print Message: The item is unavailable!
        if(quantity <= 0) {
            outOfStock = true;
            System.out.println("Message: The item is unavailable!");
        }
        
        // If outOfStock is false then print the message and total.
        if(!outOfStock) {
            System.out.println(message+"\nTotal: "+total);
        }
    }
}