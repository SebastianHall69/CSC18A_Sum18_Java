public class LabCourse extends CollegeCourse
{
    //Private data fields
    private final int LAB_COST;
    //Public methods
    LabCourse(String dept, int course, int credits)
    {
        super(dept, course, credits);
        LAB_COST = 50;
        setFee(getFee() + LAB_COST);
    }
    @Override
    public void display()
    {
        System.out.println("Lab Course");
        super.display();
    }
}
