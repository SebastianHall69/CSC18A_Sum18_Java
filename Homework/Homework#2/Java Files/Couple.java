public class Couple
{
    //Private data fields
    Person groom;
    Person bride;
    
    //Public methods
    public Couple(Person groom, Person bride)
    {
        this.groom = groom;
        this.bride = bride;
    }
    public Person getGroom()
    {
        return groom;
    }
    public Person getBride()
    {
        return bride;
    }
    public void display()
    {
        System.out.print("Groom: ");
        groom.display();
        System.out.print("Bride: ");
        bride.display();
    }
}
