public class Employee {

    //Define class variables
    private String empName;
    private String empID;
    private double empSalary;

    //create constructor
    public Employee(String name, String id, double salary){
        this.empName = name;
        this.empID = id;
        this.empSalary = salary;
    }

    public Employee(){

    }

    //modifier methods
    public void setName(String name){
        this.empName = name;
    }

    public void setID(String id){
        this.empID = id;
    }

    public void setSal(double pay){
        this.empSalary = pay;
    }

    //accessory methods
    public String getName(){
        return empName;
    }

    public String getId(){
        return empID;
    }

    public double getSalary(){
        return empSalary;
    }
}
