package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import java.util.Scanner;

public class AIMS {

    public static void main(String[] args)                              
    {
        Cart newOrder = new Cart();         
        DigitalVideoDisc disc_1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc disc_2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);

        DigitalVideoDisc disc_3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        //DigitalVideoDisc[] dvdList = {disc_1, disc_2, disc_3};

        newOrder.addDigitalVideoDisc(disc_1, disc_2);               // add dvd and notify when dvd has added or not
        newOrder.addDigitalVideoDisc(disc_3);
    
        System.out.println("********************Cart********************");

        newOrder.printCart();                               // print out all information of dvds && total cost

        System.out.println("********************************************");

        newOrder.removeDigitalVideoDisc(disc_3);                           // remove disc Aladin
        System.out.print("Total cost after remove disc 3 is: ");        //  print total cost after remove disc Aladin
        System.out.println(newOrder.totalCost());
    }
}