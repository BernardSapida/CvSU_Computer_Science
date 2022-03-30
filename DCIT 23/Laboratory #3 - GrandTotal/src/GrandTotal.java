import java.text.DecimalFormat;

public class GrandTotal {
    public double tax = .05;
    public double tip = .15;
    public static double tableTotal;
    public static void main(String[] args) throws Exception {
        DecimalFormat df = new DecimalFormat(".##");
        GrandTotal gt = new GrandTotal();

        // Each bill of eight person
        System.out.println("Person 1: " + gt.findTotal(10, df));
        System.out.println("Person 2: " + gt.findTotal(12, df));
        System.out.println("Person 3: " + gt.findTotal(9, df));
        System.out.println("Person 4: " + gt.findTotal(8, df));
        System.out.println("Person 5: " + gt.findTotal(7, df));

        // Since Alex meal was meant to be a birthday present.
        // Therefore, his/her bill are distributed to his/her friends equally.
        // System.out.println("Person 6: " + gt.findTotal(15) + " (Alex)");

        System.out.println("Person 7: " + gt.findTotal(11, df));

        // Since person 8 forget the wallet. Therefore, he/she is not included.
        // The person 8 bill's shared to his/her 6 friends equally.
        // System.out.println("Person 8: " + gt.findTotal(30));

        // Table's Total Bill
        System.out.println("Table's Total: " + df.format(tableTotal));
    }

    public double findTotal(double originalPrice, DecimalFormat df) {
        // Alex bill
        double person6 = (15*(1 + this.tax + this.tip))/6;

        // Person 8 bill
        double person8 = (30*(1 + this.tax + this.tip))/6;

        // Person # Total Bill
        double personTotal = Double.parseDouble(df.format(originalPrice*(1 + this.tax + this.tip) + person8 + person6));

        // Table Total
        tableTotal += personTotal;

        return personTotal;
    }
}

/*
  * It’s Alex’s birthday! You’ve arranged a group of eight friends to celebrate at a local restaurant.
  * When your party receives their bill, nobody is quite sure what they owe.
  * You only know everyone’s total before tax (5%) and tip (15%). 
  * But lucky you! You brought your laptop and are asked to write a program that calculates everybody’s total

  * Person1: $10
  * Person2: $12
  * Person3: $9
  * Person4: $8
  * Person5: $7
  * Person6: $15 (Alex)
  * Person7: $11
  * Person8: $30

  ? Find and print the entire table’s total, including tax and tip.
  ! You'll need to edit findTotal() so that it returns its calculated value.
  ! Person8 forgot their wallet. And Alex’s meal was meant to be a birthday present. 
  ! Modify findTotal() so that the cost of their meals are shared equally with the rest of the party.
  ? Recalculate the entire table’s total. 
*/
