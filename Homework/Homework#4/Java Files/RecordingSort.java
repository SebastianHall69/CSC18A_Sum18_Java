//Import
import javax.swing.JOptionPane;

//Recording class
public class RecordingSort
{
    public static void main(String [] args)
    {
        //Declare variables/objects
        final int SUB = 5;
        Recording[] records = new Recording[SUB];
        String entry = null;
        int choice = 0;
        
        //Initialize 5 recordings with user
        for(int i = 0; i < SUB; ++i)
            records[i] = fillSong();
            
        //Prompt user sort choice
        entry = JOptionPane.showInputDialog(null, 
            "Would you like the songs sorted by :\n" +
            "1.) Title\n" + 
            "2.) Artist Name\n" +
            "3.) Play Time",
            "Enter An Integer Choice Please", 
            JOptionPane.QUESTION_MESSAGE);
        choice = Integer.parseInt(entry);
        
        //Sort and display records
        sort(records, choice);
        display(records);
    }
    public static void sort(Recording[] records, int choice)
    {
        //Declare variables
        Recording temp;
        final int SUB = records.length - 1;
        
        //Sort array based upon choice
        switch(choice)
        {
            case 1:
            {
                for(int i = 0; i < SUB; ++i)
                    for(int j = 0; j < SUB; ++j)
                        if(records[j].getTitle().toLowerCase().compareTo(
                            records[j + 1].getTitle().toLowerCase()) > 0)
                        {
                            temp = records[j];
                            records[j] = records[j + 1];
                            records[j + 1] = temp;
                        }
            }
            break;
            case 2:
            {
                for(int i = 0; i < SUB; ++i)
                   for(int j = 0; j < SUB; ++j)
                        if(records[j].getArtist().toLowerCase().compareTo(
                            records[j + 1].getArtist().toLowerCase()) > 0)
                        {
                            temp = records[j];
                            records[j] = records[j + 1];
                            records[j + 1] = temp;
                        }
            }
            break;
            case 3:
            {
                for(int i = 0; i < SUB; ++i)
                    for(int j = 0; j < SUB; ++j)
                        if(records[j].getPlayTime() > records[j + 1].getPlayTime())
                        {
                            temp = records[j];
                            records[j] = records[j + 1];
                            records[j + 1] = temp;
                        }
            }
            break;
        }   
    }
    public static Recording fillSong()
    {
        //Declare variables
        String entry = null;
        Recording record = new Recording();
        
        //Get recording data from user
        entry = JOptionPane.showInputDialog(null,
            "Enter the song's title", 
            "Music Records", 
            JOptionPane.QUESTION_MESSAGE);
        record.setTitle(entry);
        entry = JOptionPane.showInputDialog(null,
            "Enter the song's artist", 
            "Music Records", 
            JOptionPane.QUESTION_MESSAGE);
        record.setArtist(entry);
        entry = JOptionPane.showInputDialog(null,
            "Enter the song's play time in seconds", 
            "Music Records", 
            JOptionPane.QUESTION_MESSAGE);
        record.setPlayTime(Integer.parseInt(entry));
        
        //Return record
        return record;
    }
    public static void display(Recording[] record)
    {
        StringBuilder list = new StringBuilder(100);
        final int SUB = record.length;
        
        for(int i = 0; i < SUB; ++i)
        {
            list.append("Song #" + (i + 1) + "\n");
            list.append("Title:     " + record[i].getTitle() + "\n");
            list.append("Artist:    " + record[i].getArtist() + "\n");
            list.append("Play Time: " + record[i].getPlayTime() + "\n\n");
        }
        JOptionPane.showMessageDialog(null, list, 
            "Sorted Record", JOptionPane.PLAIN_MESSAGE);
    }
}
