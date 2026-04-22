package hust.soict.hedspi.test.cart;

import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args)
    {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.printCart();

        Scanner sc = new Scanner(System.in);                            
        System.out.print("Id of DVD: ");                               
        int id = sc.nextInt();
        cart.findCart(id);

        String Enter = sc.nextLine();                                   // read \n in Enter

        System.out.print("Title of DVD: ");                             
        String find_by_title = sc.nextLine();
        cart.findCart(find_by_title);
    }
}
