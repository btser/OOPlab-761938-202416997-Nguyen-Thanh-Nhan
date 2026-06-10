package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

import org.w3c.dom.stylesheets.MediaList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>() ;

    public void addMedia (Media media)
    {
        if (!itemsInStore.contains(media))
        {
            addMedia(media);
            System.out.println("The DVD has been added.");
        }else
        {
            System.out.println("The store is full.");
        }
    }

    public void removeMedia(Media media)
    {
        if (itemsInStore.contains(media))
        {
            removeMedia(media);
            System.out.println("The media has been removed.");
        }else
        {
            System.out.println("The media was not found in store.");
        }
    }
}
