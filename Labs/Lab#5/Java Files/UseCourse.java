//Import
import javax.swing.JOptionPane;

//UseCourse class
public class UseCourse
{
    public static void main(String[] args)
    {
        //Declare variables
        final String[] validClass = {"BIO", "CHM", "CIS", "PHY"};
        CollegeCourse course;
        boolean ifLab = false;
        boolean isBad = true;
        String entry = null;
        String dept = null;
        int courseNum = 0;
        int credits = 0;
        
        //Prompt user for class info
        do{
        
            try
            {
                entry = JOptionPane.showInputDialog         //Get dept
                     (null, "Enter the course department");
                dept = entry.toUpperCase();   
                entry = JOptionPane.showInputDialog         //Get courseNum
                     (null, "Enter your course number");     
                courseNum = Integer.parseInt(entry);
                if(courseNum < 0)
                    throw(new NegativeException());
                entry = JOptionPane.showInputDialog         //Get credits
                     (null, "Enter the number of credits for this course");
                credits = Integer.parseInt(entry);
                if(credits < 0)
                    throw(new NegativeException());
                isBad = false;
            }
            catch(NumberFormatException error)
            {
                JOptionPane.showMessageDialog
                    (null, "Enter An Integer for that value" + 
                    "\nStarting over now");
            }
            catch(NegativeException error)
            {
                JOptionPane.showMessageDialog
                    (null, error.getMessage());
            }
            catch(Exception error)
            {
                JOptionPane.showMessageDialog
                    (null, error.getMessage() + "\nStarting over now");
            }
        }while(isBad);
        //Make decision on course type and create class
        for(int i = validClass.length - 1; i >=0; --i)
        {   
            if(dept.equals(validClass[i]))
            {
                ifLab = true;
                i = -1;
            }
        }
        if(ifLab)
            course = new LabCourse(dept, courseNum, credits);
        else   
            course = new CollegeCourse(dept, courseNum, credits);
            
        //Display data
        course.display();
    }
}
