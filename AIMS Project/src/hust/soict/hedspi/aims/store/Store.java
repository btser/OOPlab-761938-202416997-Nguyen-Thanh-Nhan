package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 500;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
    private int qtyInStore = 0;

    public void addDVD (DigitalVideoDisc dvd)
    {
        if (qtyInStore < MAX_NUMBERS_IN_STORE)
        {
            qtyInStore++;
            itemsInStore[qtyInStore] = dvd;
            System.out.println("The DVD has been added.");
        }else
        {
            System.out.println("The store is full.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd)
    {
        for (int i = 0; i < qtyInStore; i++)
        {
            if (itemsInStore[i].equals(dvd))
            {
                for (int j = i; j < qtyInStore - 1; j++)
                {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The disc " + dvd.getTitle() + " has removed.");
                return;
            }
        }
        System.out.println("The disc was not found in store.");
    }
}
