//Import
import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

//ReadStateFile class
public class ReadStateFile
{
    public static void main(String [] args)
    {
        //Declare variables/objects
        Scanner cin = new Scanner(System.in);
        String fileName = null;
        final String ID_FORMAT = "000";
        final String NAME_FORMAT = "          ";
        final int NAME_LENGTH = NAME_FORMAT.length();
        final String HOME_STATE = "WI";
        final String BALANCE_FORMAT = "0000.00";
        String delimiter = ",";
        String s = ID_FORMAT + delimiter + NAME_FORMAT + delimiter +
            HOME_STATE + delimiter + BALANCE_FORMAT +
            System.getProperty("line.separator");
        final int RECSIZE = s.length();
        byte[] data = s.getBytes();
        final String EMPTY_ACCT = "000";
        String[] array = new String[4];
        double balance = 0.0;
        double total = 0.0;
        
        //Get file name from user and create path
        System.out.print("Enter the file name: ");
        fileName = cin.nextLine();
        fileName = "/home/sebastian/Desktop/" + fileName;
        Path file = Paths.get(fileName);
        
        //Output file attributes
        try
        {
            BasicFileAttributes attr = Files.readAttributes
                (file, BasicFileAttributes.class);
            System.out.println("File Attributes:");
            System.out.println("Creation time: " + attr.creationTime());
            System.out.println("File size: " + attr.size());
        }
        catch(IOException error)
        {
            System.out.println("IO error");
        }
        
        //Display sequentially all non default records
        try
        {
            InputStream iStream = new BufferedInputStream
                (Files.newInputStream(file));
            BufferedReader reader = new BufferedReader
                (new InputStreamReader(iStream));
            System.out.println("\n All non default records\n");
            s = reader.readLine();
            while(s != null)
            {
                array = s.split(delimiter);
                if(!array[0].equals(EMPTY_ACCT))
                {
                    balance = Double.parseDouble(array[3]);
                    System.out.println("ID #" + array[0] + " " +
                    array[1] + array[2] + " $" + array[3]);
                    total += balance;
                }
                s = reader.readLine();
            }
            System.out.println("Total balance: $" + total);
            reader.close();
        }
        catch(Exception error)
        {
            System.out.println("Message: " + error);
        }
        
        //Display user selected (random access) record
        try
        {
            FileChannel fc = (FileChannel)Files.newByteChannel(file, READ);
            ByteBuffer buffer = ByteBuffer.wrap(data);
            int findAcct = 0;
            System.out.print("Enter an account number to find: ");
            findAcct = cin.nextInt();
            fc.position(findAcct * RECSIZE);
            fc.read(buffer);
            s = new String(data);
            System.out.print("Record:" + s);
        }
        catch(Exception error)
        {
            System.out.println("Message: " + error);
        }
    }
}
