import java.text.DecimalFormat;

public class ComputeBill {
    public double tax = .05;
    public double tip = .15;
    public static double tableTotal;

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