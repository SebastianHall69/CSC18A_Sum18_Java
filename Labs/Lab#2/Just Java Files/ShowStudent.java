//Import class
import java.util.Scanner;

public class ShowStudent
{
    public static void main(String [] args)
    {
        //Declare variables
        Student matt = new Student();
        Scanner cin = new Scanner(System.in);
        
        //Prompt user and assign/process data
        System.out.print("Enter the student's id number:  ");
        matt.setId(cin.nextInt());
        System.out.print("Enter the student's credit hours:  ");
        matt.setCredHours(cin.nextFloat());
        System.out.print("Enter the student's points:  ");
        matt.setPoints(cin.nextFloat());
        matt.calcGpa();
        
        //Compute gpa and display student info
        System.out.println("Students id:  " + matt.getId());
        System.out.println("Students credit hours:  " + matt.getCredHours());
        System.out.println("Students points:  " + matt.getPoints());
        System.out.println("Students GPA:  " + matt.getGpa());
        
        //Close Scanner object
        cin.close();
    }
}
