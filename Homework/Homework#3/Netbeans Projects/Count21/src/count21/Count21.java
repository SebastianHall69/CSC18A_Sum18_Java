/*
 * Author: Sebastian Hall
 * Date: 07/03/18
 * Purpose: Count 21 game where computer will always win
 */

//Import
package count21;
import java.util.Scanner;

public class Count21
{
    public static void main(String [] args)
    {
        //Declare variables
        int total = 0;
        int val = 0;
        final int MAX = 21;
        Scanner cin = new Scanner(System.in);
        boolean youLose = false;
        
        //Prompt user
        System.out.println("Count 21");
        while(total <= MAX)
        {
            do
            {
                System.out.print("Current total: " + total +
                    "\nEnter a number 1 through 3 to reach 21" +
                    "\nChoice: ");
                val = cin.nextInt();
            } while(val < 1 || val > 3);
            total += val;
            if(total > MAX)
                youLose = true;
            val = compGuess(total);
            total +=val;
            System.out.println("The computer added " + val + "\n\n");
        }
        if(youLose)
            System.out.println("You lose\nYou made the total exceed " +
                MAX + " by making the total " + total);
        else
            System.out.println("The computer loses");
    }
    
    public static int compGuess(int total)
    {
        int guess = 0;
        if(total < 15)
            guess = (int) (Math.random() * 3) +1;
        else if(total < 17)
            guess = 1;
        else if(total <21)
            guess = 21 - total;
        else
            guess = 0;
        return guess;
    }
}
