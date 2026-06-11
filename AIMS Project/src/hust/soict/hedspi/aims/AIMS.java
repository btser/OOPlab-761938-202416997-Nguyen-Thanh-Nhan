package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AIMS {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc( "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book1 = new Book( "Star Wars", "Science Fiction", 24.95f);
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Quincy Jones", 42, 15.00f, "Michael Jackson");
        
        store.addMedia(dvd1);
        store.addMedia(book1);
        store.addMedia(cd1);

        showMenu();
    }

    public static void showMenu() {
        while (true) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0: System.exit(0);
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void viewStore() {
        store.print();
        while (true) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    store.searchByTitle(title);
                    break;
                case 2:
                    System.out.print("Enter the title to add: ");
                    String tAdd = scanner.nextLine();
                    Media mAdd = store.searchByTitle(tAdd);
                    if (mAdd != null) {
                        try {
                            cart.addMedia(mAdd);
                            System.out.println("Items in cart: " + cart.getItemsCount()); 
                        } catch (Exception e) {
                            System.err.println(e.toString());
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else System.out.println("Media not found.");
                    break;
                case 3:
                    System.out.print("Enter title to play: ");
                    String tPlay = scanner.nextLine();
                    Media mPlay = store.searchByTitle(tPlay);
                    if (mPlay instanceof Playable) {
                        try {
                            ((Playable) mPlay).play();
                        } catch (Exception e) {
                            System.err.println(e.toString());
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else System.out.println("This media cannot be played.");
                    break;
                case 4: viewCart(); break;
                case 0: return;
            }
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void viewMediaDetails(Media media) {
        while (true) {
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    try {
                        cart.addMedia(media); 
                    } catch (Exception e) {
                        System.err.println(e.toString());
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    if (media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (Exception e) {
                            System.err.println(e.toString());
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else System.out.println("This media cannot be played.");
                    break;
                case 0: return;
            }
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void updateStore() {
        System.out.println("1. Add Media to Store\n2. Remove Media from Store\n0. Back");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("Feature adding new media...");
        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            if (m != null) store.removeMedia(m);
        }
    }

    public static void viewCart() {
        cart.printCart();
        while (true) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("1. By ID, 2. By Title");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (filterChoice == 1) {
                        System.out.print("Enter ID to filter: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        cart.searchById(id);
                    } else if (filterChoice == 2) {
                        System.out.print("Enter title to filter: ");
                        String title = scanner.nextLine();
                        cart.searchByTitle(title);
                    } else {
                        System.out.println("Invalid option");
                    }
                    break;
                case 2: 
                    System.out.println("1. By Title, 2. By Cost");
                    int s = scanner.nextInt();
                    scanner.nextLine();
                    if (s == 1) cart.sortByTitle();
                    else if (s == 2) cart.sortByCost();
                    else System.out.println("Invalid option");
                    cart.printCart();
                    break;
                case 3: 
                    System.out.print("Enter title: ");
                    Media m = cart.searchByTitle(scanner.nextLine());
                    if (m != null) cart.removeMedia(m);
                    break;
                case 4: 
                    System.out.print("Enter title: ");
                    Media p = cart.searchByTitle(scanner.nextLine());
                    if (p instanceof Playable) {
                        try {
                            ((Playable) p).play();
                        } catch (Exception e) {
                            System.err.println(e.toString());
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Order created! Emptying cart...");
                    cart.clear(); 
                    return;
                case 0: return;
            }
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }
}