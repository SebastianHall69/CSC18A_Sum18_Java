//Import
import java.util.Scanner;

//RockPaperScissors class
public class RockPaperScissors
{
    public static void main(String [] args)
    {
        //Declare and initialize variables
        int compChoice = 0;
        int usrChoice = 0;
        Scanner cin = new Scanner(System.in);
        
        //Get random computer choice
        compChoice = (int) (Math.random() * 3) + 1;
        
        //Get user choice
        System.out.println("Rock Paper Scissors\n");
        while(usrChoice < 1 || usrChoice > 3)
        {
            System.out.print("Enter your integer choice\n" +
                "1.) Rock\n" +
                "2.) Paper\n" +
                "3.) Scissors\n" +
                "Choice: ");
            usrChoice = cin.nextInt();
        }
        
        //Evaluate winner
        if(usrChoice == 1 && compChoice == 3 ||
            usrChoice == 2 && compChoice == 1 ||
            usrChoice == 3 && compChoice == 2)
                System.out.println("You beat the computers " +
                    choice(compChoice) + " with your " + choice(usrChoice));
        else if(compChoice == 1 && usrChoice == 3 ||
            compChoice == 2 && usrChoice == 1 ||
            compChoice == 3 && usrChoice == 2)
                System.out.println("The computer beat your " +
                    choice(usrChoice) + " with " + choice(compChoice));
        else
            System.out.println("You tied the computer with " +
                choice(usrChoice));
        
        
    }
    public static String choice(int choice)
    {
        //Declare variable
        String word = "";
        
        //Determine value for word
        switch(choice)
        {
            case 1:
                word = "rock";
                break;
            case 2:
                word = "paper";
                break;
            case 3:
                word = "scissors";
                break;
        }
        //Return word
        return word;
    }
}
