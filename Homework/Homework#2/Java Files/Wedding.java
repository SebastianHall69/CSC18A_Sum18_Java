//Import class
import java.time.LocalDate;

//Wedding class
public class Wedding
{
    //Data fields
    private LocalDate weddingDate;
    private Couple couple;
    private String location;
    public static int wedCount = 0;
    
    //Public methods
    public Wedding(LocalDate weddingDate, Couple couple, String location)
    {
        this.weddingDate = weddingDate;
        this.couple = couple;
        this.location = location;
    }
    public LocalDate getWeddingDate()
    {
        return weddingDate;
    }
    public Couple getCouple()
    {
        return couple;
    }
    public String getLocation()
    {
        return location;
    }
    public void display()
    {
        System.out.println("Location: " + location);
        System.out.println("Date: " + weddingDate);
        couple.display();
    }
}
