import java.time.LocalDate;

public class Person
{
    //Data fields
    private String fName;
    private String lName;
    private LocalDate birthday;
    
    //Public methods
    public Person(String fName, String lName, LocalDate birthday)
    {
        this.fName = fName;
        this.lName = lName;
        this.birthday = birthday;
    }
    public String getFName()
    {
        return fName;
    }
    public String getLName()
    {
        return lName;
    }
    public LocalDate getBirthday()
    {
        return birthday;
    }
    public void display()
    {
        System.out.println(fName + " " + lName + " Born " + birthday);
    }
}
