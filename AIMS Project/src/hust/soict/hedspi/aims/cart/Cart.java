package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media> ();

    public void addMedia(Media media)
    {
        if (!itemsOrdered.contains(media))
        {
            itemsOrdered.add(media);
            System.out.println("The media has been added:" + media.getTitle());
        }else
            System.out.println("The media is already in the cart.");
    }

    public void removeMedia(Media media)
    {
        if (itemsOrdered.contains(media))
        {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed: " + media.getTitle());
        }else
            System.out.println("Cound not found the media");
    }
    
    public float totalCost()
    {
        float total_cost = 0;
        for (Media media : itemsOrdered)
        {
            total_cost += media.getCost();
        }
        return total_cost;
    }

    public void printCart()                                                         // Test and print DVD, total cost
    {
        for (Media media : itemsOrdered)
        {
            System.out.println(media.toString());
        }
        System.out.println("Total cost is: " + totalCost());
    }

    public void sortByTitle() 
    {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);            // Sort by title in cart
    }

    public void sortByCost() 
    {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);            // Sort by cost in cart
    }

    public int getItemsCount() {
        return itemsOrdered.size();
    }

    public Media searchById(int id) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item != null && item.getId() == id) {
                System.out.println("Match found: " + item.toString());
                found = true;
                return item;
            }
        }
        
        if (!found) {
            System.out.println("No DVD with ID: " + id + " was found in the cart.");
        }

        return null;
    }

    public Media searchByTitle(String title) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item != null && item instanceof Media && item.isMatch(title)) {
                System.out.println("Match found: " + item.toString());
                found = true;
                return item;
            }
        }
        
        if (!found) {
            System.out.println("No DVD with title: " + title + " was found in the cart.");
        }

        return null;
    }

    
    public void clear() {
        itemsOrdered.clear();
    }
}
