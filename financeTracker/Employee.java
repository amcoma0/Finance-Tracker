public class Employee extends User {

    private double salary;

    public Employee (int userID, String name, double salary)
    {
        super(userID, name);
        this.salary = salary;
    }

    public double getSalary()
    {
        return this.salary;
    }

    public void setSalary(double newSalary)
    {
        this.salary = newSalary;
    }
}