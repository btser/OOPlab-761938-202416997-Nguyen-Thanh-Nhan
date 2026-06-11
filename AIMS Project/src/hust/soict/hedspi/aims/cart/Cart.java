package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hedspi.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import hust.soict.hedspi.aims.exception.LimitExceededException;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("The media has been added: " + media.getTitle());
            } else {
                System.out.println("The media is already in the cart.");
            }
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed: " + media.getTitle());
        } else {
            System.out.println("The media was not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i + ". " + media.toString());
            i++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
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

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by Title.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by Cost.");
    }

    public void clear() {
        itemsOrdered.clear();
    }

    // Getters and Setters
    public static int getMaxNumbersOrdered() {
        return MAX_NUMBERS_ORDERED;
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public int getItemsCount() {
        return itemsOrdered.size();
    }
}
