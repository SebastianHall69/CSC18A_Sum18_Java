public class ShowStudent2
{
    public static void main(String [] args)
    {
        //Declare variable
        Student matt = new Student();
        
        //Compute gpa and display student info
        matt.calcGpa();
        System.out.println("\n\nJust the constructor values");
        System.out.println("Students id:  " + matt.getId());
        System.out.println("Students credit hours:  " + matt.getCredHours());
        System.out.println("Students points:  " + matt.getPoints());
        System.out.println("Students GPA:  " + matt.getGpa());
        
    }
}
