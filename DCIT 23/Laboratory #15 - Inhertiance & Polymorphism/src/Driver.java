public abstract class Driver {
    protected String driverName = "John Doe";
    protected String licenseNumber = "D0001234567";
    protected int busAssign = 17;

    // Creating an abstract method.
    abstract void displayInfo();
    abstract void getInfo();
}