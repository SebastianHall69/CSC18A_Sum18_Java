/**
 * Author: Sebastian Hall
 * Date: 06/26/18
 * Purpose: Lab #2 Student class
 */

package showstudent;
public class Student
{
    //Declare private fields
    private int id;
    private float credHours;
    private float points;
    private float gpa;
    
    //Public Methods
    Student()
    {
         id = 9999;
         credHours = 3.0F;
         points = 12.0F;
         gpa = 0.0F;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
    public void setCredHours(float credHours)
    {
        this.credHours = credHours;
    }
    public float getCredHours()
    {
        return credHours;
    }
    public void setPoints(float points)
    {
        this.points = points;
    }
    public float getPoints()
    {
        return points;
    }
    public void calcGpa()
    {
        gpa = points / credHours;
    }
    public float getGpa()
    {
        return gpa;
    }
}