//Import statements
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

//CalculatorDemo2 class
public class CalculatorDemo2
{
    public static void main(String [] args) throws IOException
    {
        //Declare variables
        Scanner cin = new Scanner(System.in);
        Process proc = Runtime.getRuntime().exec
            ("cmd /c C:\\Windows\\System32\\calc.exe");
        final int ROUNDS = 5;
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        int userAnswer;
        
        
        
        for(int i = 0; i < ROUNDS; ++i)
        {
            //Calculate random values to add
                num1 = (int) (Math.random() * 4999) + 1;
                num2 = (int) (Math.random() * 4999) + 1;

           //Prompt user for answer
            try
            {
                System.out.println
                    ("Round " + (i + 1) + "What is the sum of " +
                     num1 + " + " + num2 + ": ");
                userAnswer = cin.nextInt();
                if(userAnswer == result)
                    System.out.println
                        ("Correct, moving on to round " + (i + 1));
                else
                  System.out.println
                      ("Sorry, the correct answer is " + result);    
            }
            catch(InputMismatchException error)
            {
                System.out.println("That is not a number and therefore wrong");
                if( i < 4)
                    System.out.println("Moving on to problem #" + (i + 1));
                else
                    System.out.println("Thats all the problems");
            }
        }
    }
}
