/**
 * File: MinutesConversion.java
 * Author: Sebastian Hall
 * Date: 06/22/18
 * Purpose: Homework #1 convert minutes to hours and days
 */
 
 //Import Packages
 import javax.swing.JOptionPane;

//Class Declaration
public class MinutesConversion
{
    //Main Function
    public static void main(String [] args)
    {
        //Declare variables
        String results = "";
        int minutes = 0;
        float hours = 0.0F;
        float days = 0.0F;
        
        //Prompt user input
        results = JOptionPane.showInputDialog(null,
            "Enter a number of minutes",
            "Minute Converter",
            JOptionPane.PLAIN_MESSAGE);
            
        //Process Data
        minutes = Integer.parseInt(results);
        hours = (float) minutes / 60;
        days = (float) minutes / (60 * 24);
        
        //Output Data
        JOptionPane.showMessageDialog(null,
            "Hours: " + hours + "\nDays: " + days + "\n",
            "Results",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
