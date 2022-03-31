import java.text.DecimalFormat;

public class GrandTotal {
    public static void main(String[] args) throws Exception {
        DecimalFormat df = new DecimalFormat("0.00");
        ComputeBill cb = new ComputeBill();

        // Each bill of eight person
        System.out.println("Person 1: $" + cb.findTotal(10, df));
        System.out.println("Person 2: $" + cb.findTotal(12, df));
        System.out.println("Person 3: $" + cb.findTotal(9, df));
        System.out.println("Person 4: $" + cb.findTotal(8, df));
        System.out.println("Person 5: $" + cb.findTotal(7, df));

        // Since Alex meal was meant to be a birthday present.
        // Therefore, his/her bill are distributed to his/her friends equally.
        // System.out.println("Person 6: $" + cb.findTotal(15, df) + " (Alex)");

        System.out.println("Person 7: $" + cb.findTotal(11, df));

        // Since person 8 forget the wallet. Therefore, he/she is not included.
        // The person 8 bill's shared to his/her 6 friends equally.
        // System.out.println("Person 8: $" + cb.findTotal(30, df));

        // Table's Total Bill
        System.out.println("Table's Total: $" + df.format(ComputeBill.tableTotal));
    }
}

/*
  ? 8 Persons Total Bill
  * Person 1: $12.0
  * Person 2: $14.4       
  * Person 3: $10.8       
  * Person 4: $9.6        
  * Person 5: $8.4        
  * Person 6: $18.0 (Alex)
  * Person 7: $13.2       
  * Person 8: $36.0       
  * Table's Total: $122.40

  ? 6 Persons Total Bill (Alex & Person 8 Bill's Truncated)
  * Person 1: $21.0
  * Person 2: $23.4       
  * Person 3: $19.8       
  * Person 4: $18.6       
  * Person 5: $17.4       
  * Person 7: $22.2       
  * Table's Total: $122.40
*/
