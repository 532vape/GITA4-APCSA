import javax.management.StringValueExp;

//student inherits all attributes of PersonClass
//Student is a more specific person
public class Student extends PersonClass{
    private double dblGPA;

    //declare our constructor
    Student(String nameL, String nameF, String address, String city, String state, String zip, String phone, double GPA){
        super(nameL, nameF, address, city, state, zip, phone);
        dblGPA = GPA;
    }

    public double getGPA(){
        return dblGPA;
    }

    @Override
    public String getPhone(){
        strPhone = strPhone + " x4719";
        return strPhone;
    }
}
