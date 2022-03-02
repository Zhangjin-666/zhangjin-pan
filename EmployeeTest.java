import java.lang.Override;

/**
 * Problem 2 [40pts]
 * Create a class Employee that includes the following instance variables
 * • First name (String) cannot be empty,
 * • Last name (String) cannot be empty,
 * • Monthly salary (double) must be non-negative.
 * Provide a set and a get method for each instance variable. The setters must return boolean
 * and perform validation. If the monthly salary is not positive, set its value to zero. If a name is
 * empty set it to “[empty]”. 
 * Provide a constructor that initializes the three instance variables.
 * No default constructor is required. Also, overwrite equals() and toString(). Write a
 * test class named EmployeeTest that demonstrates class Employee’s capabilities. Create two
 * different Employee objects. Use println() to display information about each employee (this
 * will invoke toString()). Then compare the two using equals() and display the result.
 * Submission format: You MUST define TWO classes. One is Employee which must be declared
 * as a non-public class. Two is EmployeeTest which is public and contains the main()
 * method. So, you must submit one file EmployeeTest.java containing the above two classes.
 * The tests must be performed in the main() method.
 */
class Employee{
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) throws IllegalAccessException{
        this.firstName = firstName;
        this.lastName = lastName;
        if (salary < 0)  throw new IllegalAccessException("Salary must be non-negative.");
        this.salary = salary;
    }

   
    // set and get
    public void setFirstName(String firstName) {
        if (firstName == null) this.firstName =  "[empty]";
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) this.lastName =  "[empty]";
        this.lastName = lastName;
    }

    public boolean setSalary(double salary){
        if (salary < 0) {
            salary = 0;
            return false;
        }
        this.salary = salary;
        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public boolean equals(Employee otherPeople) {
        if (firstName.equals(otherPeople.getFirstName()) && lastName.equals(otherPeople.getLastName()) && salary == otherPeople.getSalary()) return true;
        else return false;
    }
    
    @Override
    public String toString(){
        return "First Name: " + firstName + "; Last Name: " + lastName + "; Salary: " + salary;
    }
}

public class EmployeeTest {
    public static void main(String[] args) throws IllegalAccessException {
        Employee p1 = new Employee("Patrick", "Smith", 99999);
        Employee p2 = new Employee("Patrick", "Smith", 99999);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        System.out.println(p1.equals(p2));
    }
}
