//Import
import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.text.*;

//CreateFilesBasedOnState class
public class CreateFilesBasedOnState
{
    public static void main(String[] args)
    {
        //Declare variables/objects
        Scanner cin = new Scanner(System.in);
        Path inStateFile =
            Paths.get("C:\\Java\\Chapter.13\\InStateCusts.txt");
        Path outOfStateFile =
            Paths.get("C:\\Java\\Chapter.13\\OutOfStateCusts.txt");
        final String ID_FORMAT = "000";
        final String NAME_FORMAT = "          ";
        final int NAME_LENGTH = NAME_FORMAT.length();
        final String HOME_STATE = "WI";
        final String BALANCE_FORMAT = "0000.00";
        String delimiter = ",";
        String s = ID_FORMAT + delimiter + NAME_FORMAT +
            delimiter + HOME_STATE + delimiter + BALANCE_FORMAT +
            System.getProperty("line.separator");
        final int RECSIZE = s.length();
        FileChannel fcIn = null;
        FileChannel fcOut = null;
        String idString = null;
        int id = 0;
        String name = null;
        String state = null;
        double balance = 0.0;
        final String QUIT = "999";
        
        //Create empty files for records
        createEmptyFile(inStateFile, s);
        createEmptyFile(outOfStateFile, s);
        
        try
        {
            //Set FileChannel references
            fcIn = (FileChannel) Files.newByteChannel
                (inStateFile, CREATE, WRITE);
            fcOut = (FileChannel) Files.newByteChannel
                (outOfStateFile, CREATE, WRITE);
                
            //Get account info from user with loop
            System.out.print("Enter the customer account number or " + 
                    QUIT + " to quit: ");
            idString = cin.nextLine();
            while(idString.equals(QUIT) == false)
            {
                id = Integer.parseInt(idString);
                System.out.print("Enter the customers name: ");
                name = cin.nextLine();
                StringBuilder sb = new StringBuilder(name);
                sb.setLength(NAME_LENGTH);
                name = sb.toString();
                System.out.print("Enter the state: ");
                state = cin.nextLine();
                System.out.print("Enter the balance: ");
                balance = cin.nextDouble();
                cin.nextLine();
                DecimalFormat df = new DecimalFormat(BALANCE_FORMAT);
                
                //Build String and write to appropriate file
                s = idString + delimiter + name + delimiter + state +
                    delimiter + df.format(balance) + 
                    System.getProperty("line.separator");
                byte[] data = s.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(data);
                if(state.equals(HOME_STATE))
                {
                    fcIn.position(id * RECSIZE);
                    fcIn.write(buffer);
                }
                else
                {
                    fcOut.position(id * RECSIZE);
                    fcOut.write(buffer);
                }
                
                //Begin getting user data again
                System.out.print("Enter the customer account number or " + 
                    QUIT + " to quit: ");
                idString = cin.nextLine();
            }
            //Close FileChannel objects
            fcIn.close();
            fcOut.close();
            
        }
        catch(Exception error)
        {
            System.out.println("Message: " + error);
        }
    }
    public static void createEmptyFile(Path file, String s)
    {
        //Declare variable/objects and write s to file 1000 times
        final int NUM_RECS = 1000;
        try
        {
            OutputStream outputStr = new BufferedOutputStream
                (Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter
                (new OutputStreamWriter(outputStr));
            for(int i = 0; i< NUM_RECS; ++i)
            {
                writer.write(s, 0, s.length());
            }
            writer.close();
        }
        catch(Exception error)
        {
            System.out.println("Message: " + error);
        }
        
    }
}
