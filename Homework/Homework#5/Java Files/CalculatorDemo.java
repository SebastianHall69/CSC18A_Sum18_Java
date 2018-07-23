//Import statements
import java.util.Scanner;
import java.io.IOException;

//CalculatorDemo class
public class CalculatorDemo
{
    public static void main(String [] args) throws IOException
    {
        //Declare variables
        Scanner cin = new Scanner(System.in);
        Process proc = Runtime.getRuntime().exec
            ("cmd /c C:\\Windows\\System32\\calc.exe");
        double num1 = 279.6;
        double num2 = 872.8;
        double answer = num1 + num2;
        double userAnswer;
        
        //Prompt user for answer
        System.out.println
            ("What is the sum of " + num1 + " + " + num2 + ": ");
        userAnswer = cin.nextDouble();
        if(userAnswer == answer)
            System.out.println("Correct");
        else
            System.out.println("Sorry, the correct answer is " + answer);    
        
    }
}
