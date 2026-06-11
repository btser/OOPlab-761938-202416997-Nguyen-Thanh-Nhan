package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.*;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 10000;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();    
    
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added '" + media.getTitle() + "' to the store.");
        } else {
            System.out.println("'" + media.getTitle() + "' is already in the store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed '" + media.getTitle() + "' from the store.");
        } else {
            System.out.println("Could not find '" + media.getTitle() + "' in the store.");
        }
    }
    
    public void print() {
        System.out.println("***********************STORE***********************");
        int i = 1;
        for (Media media : itemsInStore) {
            System.out.println(i + ". " + media.toString());
            i++;
        }
        System.out.println("***************************************************");
    }

    public Media searchById(int id) {
        for (Media item : itemsInStore) {
            if (item != null && item.getId() == id) {
                System.out.println("Match found: " + item.toString());
                return item;
            }
        }
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media item : itemsInStore) {
            if (item != null && item instanceof Media && item.isMatch(title)) {
                System.out.println("Match found: " + item.toString());
                return item;
            }
        }
        return null;
    }

    // Getters and setters    
    public static int getMaxNumbersInStore() {
        return MAX_NUMBERS_IN_STORE;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void setItemsInStore(ArrayList<Media> itemsInStore) {
        this.itemsInStore = itemsInStore;
    }
}
