/*
 * Author: Sebastian Hall
 * Date: 06/28/18
 * Purpose: Display two objects from the Wedding class
 */

//Import
package testwedding;
import java.time.LocalDate;

//TestWedding class
public class TestWedding
{
    public static void main(String [] args)
    {
        //Declare variables
        LocalDate bDay1, bDay2, bDay3, bDay4, wedDate1, wedDate2;
        Person groom1, bride1, groom2, bride2;
        Couple couple1, couple2;
        Wedding first, second;
        
        //Initialize variables
        bDay1 = LocalDate.of(1962,5,13);
        bDay2 = LocalDate.of(2004,1,24);
        bDay3 = LocalDate.of(1845,12,7);
        bDay4 = LocalDate.of(1998,3,22);
        wedDate1 = LocalDate.of(2020, 9, 11);
        wedDate2 = LocalDate.of(2022, 2, 15);
        groom1 = new Person("Yang", "Wen li", bDay1);
        groom2 = new Person("Reinhard","Von Lohengramm",bDay3);
        bride1 = new Person("Frederica","Greenhill",bDay2);
        bride2 = new Person("Hildegard","Von Mariendorf",bDay4);
        couple1 = new Couple(groom1, bride1);
        couple2 = new Couple(groom2, bride2);
        first = new Wedding(wedDate1, couple1,
            "Heinessenpolis, Heinessen Wedding Chapel");
        second = new Wedding(wedDate2, couple2,
            "New Imperial Capital, Phezzan");
        
        //Output weddings
        display(first);
        display(second);
    }
    public static void display(Wedding wedding)
    {
        System.out.println("\nWedding #" + ++Wedding.wedCount);
        wedding.display();
    }
}