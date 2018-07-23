public class CollegeCourse
{
    //Private Data Fields
    private String dept;
    private int courseNum;
    private int credits;
    private int fee;
    
    //Public methods
    CollegeCourse(String dept, int courseNum, int credits)
    {
        this.dept = dept;
        this.courseNum = courseNum;
        this.credits = credits;
        fee = credits * 120;
    }
    public void display()
    {
        System.out.println(dept + " " + courseNum + "\nCredits: " +
            credits + "\nFee: $" + fee);
    }
    public String getDept()
    {
        return dept;
    }
    public void setDept(String dept)
    {
        this.dept = dept;
    }
    public int getCourseNum()
    {
        return courseNum;
    }
    public void setCourseNum(int courseNum)
    {
        this.courseNum = courseNum;
    }
    public int getCredits()
    {
        return credits;
    }
    public void setCredits(int credits)
    {
        this.credits = credits;
    }
    public int getFee()
    {
        return fee;
    }
    public void setFee(int fee)
    {
        this.fee = fee;
    }
}
