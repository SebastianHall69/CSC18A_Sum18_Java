package recordingsort;
public class Recording
{
    //Private fields
    private String title;
    private String artist;
    private int playTime;
    
    //Public methods
    Recording()
    {
        title = "N/A";
        artist = "N/A";
        playTime = 0;
    }
    Recording(String title, String artist, int playTime)
    {
        this.title = title;
        this.artist = artist;
        this.playTime = playTime;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getTitle()
    {
        return title;
    }
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
    public String getArtist()
    {
        return artist;
    }
    public void setPlayTime(int playTime)
    {
        this.playTime = playTime;
    }
    public int getPlayTime()
    {
        return playTime;
    }
}
