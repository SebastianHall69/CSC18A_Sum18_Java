/*
 * Author: Sebastian Hall
 * Date: 07/05/2018
 * Purpose: Make the secret phrase game using StringBuilder
 */


//Imports
package secretphrase;
import javax.swing.JOptionPane;

/*
 * SecretPhrase class: public, static
 * Purpose: used to play the secret phrase guessing game
 */

public class SecretPhrase
{
    public static void main(String [] args)
    {
       //Declare variables
        final String[] KEY = {"luftwaffe", "dresden", "einsatzgruppen",
                              "gestapo", "mezuzah", "nuremberg", "kaddish",
                              "shoah", "volkisch", "untermenschen",
                              "yiddish", "shabbat", "kristalnacht"};
        StringBuilder phrase;
        int index = (int) (Math.random() * 13);
        phrase = new StringBuilder(KEY[index]);
        
        //Scramble hidden phrase
        phrase = encrypt(phrase, KEY[index]);
        
        //Play game rounds until the secret phrase matches the KEY
        while(!KEY[index].equals(phrase.toString()))
            phrase = playRound(phrase, KEY[index]);
        
        //Acknowledge user guessed code correctly
        JOptionPane.showMessageDialog(null,
                "Congratulations, you correctly guessed the secret phrase: " + 
                 phrase + "\nWord bank provided by the glossary of\n" + 
                 "common German/Jewish WWII terms", 
                "You Win!",JOptionPane.PLAIN_MESSAGE);
        
    }
    
    /*
     * encrypt(): public, static, returns StringBuilder
     * Purpose: Replaces random sections of StringBuilder objects
     *          with asterisks to make the phrase hidden
     */
    
    public static StringBuilder encrypt(StringBuilder phrase,
            final String KEY)
    {
        //Insert random asterisks into each character to mask phrase
        for(int i = 0, j = 0; i < KEY.length(); ++i)
        {
            j = (int) (Math.random() * 10);
            if(j < 7)
                phrase.setCharAt(i, '*');
        }
        
        //Return scrambled secret phrase
        return phrase;
    }
    
    /*
     * playRound(): public, static, returns StringBuilder
     * Purpose: Plays a round of the game and tests user guess against
     *          key to see if any guesses are correct. If any are correct
     *          then the correct letter will replace an asterisk
     */
    
    public static StringBuilder playRound(StringBuilder phrase, 
            final String KEY)
    {
        //Declare variables
        String usrGuess = null;
        //Get character from user
        usrGuess = JOptionPane.showInputDialog(null, 
                "Secret Phrase: " + phrase,
                "Guess a letter",
                JOptionPane.PLAIN_MESSAGE);
        usrGuess = usrGuess.toLowerCase();


        //Determine letter presence and replace
        if(KEY.indexOf(usrGuess.charAt(0)) >= 0)
        {
            JOptionPane.showMessageDialog(null,
                    usrGuess.charAt(0) + " is correct!",
                    "Correct",
                    JOptionPane.INFORMATION_MESSAGE);
            for(int i = 0; i < KEY.length(); ++i)
                if(KEY.charAt(i) == usrGuess.charAt(0))
                    phrase.setCharAt(i, usrGuess.charAt(0));

        }
        else
            JOptionPane.showMessageDialog(null,
                    usrGuess.charAt(0) + " is not present",
                    "Incorrect Letter",
                    JOptionPane.ERROR_MESSAGE);
        
        //Return secret phrase
        return phrase;
    }
}
