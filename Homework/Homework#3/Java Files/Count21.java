//Import
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Count21
{
    public static void main(String [] args)
    {
        //Declare variables
        int total = 0;
        int val = 0;
        String temp = "";
        final int MAX = 21;
        Scanner cin = new Scanner(System.in);
        boolean youLose = false;
        
        //Prompt user
        while(total <= MAX)
        {
            do
            {
                temp = JOptionPane.showInputDialog(null,"Current total: " + total +
                    "\nEnter a number 1 through 3 to reach 21" +
                    "\nChoice: ", "Count 21", JOptionPane.PLAIN_MESSAGE);
                val = Integer.parseInt(temp);
            } while(val < 1 || val > 3);
            total += val;
            if(total > MAX)
                youLose = true;
            val = compGuess(total);
            total +=val;
            if(val != 0)
                JOptionPane.showMessageDialog(null, 
                    "Total: " + total + "\nThe computer added " + val + "\n\n",
                    "Computer's Turn",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if(youLose)
            JOptionPane.showMessageDialog(null, "You lose\n" +
                "You made the total exceed " +
                MAX + " by making the total " + total,
                "Loser",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "The computer loses",
                "Loser",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int compGuess(int total)
    {
        int guess = 0;
        if(total < 15)
            guess = (int) (Math.random() * 3) +1;
        else if(total < 17)
            guess = 17 - total;
        else if(total < 21 && total > 17)
            guess = 21 - total;
        else
            guess = 0;
        return guess;
    }
}
