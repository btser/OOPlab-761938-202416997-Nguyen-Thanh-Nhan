package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;
    public void addDigitalVideoDisc(DigitalVideoDisc disc)
    {
        if (qtyOrdered < MAX_NUMBERS_ORDERED)
        {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added!");
        }else
        {
            System.out.println("The cart is almost full!");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc_1, DigitalVideoDisc disc_2)
    {
        addDigitalVideoDisc(disc_1);
        addDigitalVideoDisc(disc_2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc)
    {
        if (qtyOrdered == 0)
        {
            System.out.println("There are no discs in the cart!");
        }else
        {
            for (int i = 0; i < qtyOrdered; i++)
            {
                if (itemsOrdered[i] == disc)
                {
                    for (int j = i; j < qtyOrdered - 1; j++)
                    {
                        itemsOrdered[j] = itemsOrdered[j + 1];
                    }
                    itemsOrdered[qtyOrdered - 1] = null;
                    qtyOrdered--;
                    System.out.println("The disc has been removed!");
                    return;
                }
            }
            System.out.println("The disc does not exist in the cart!");
        }
    }
    
    public float totalCost()
    {
        float total_cost = 0;
        for (int i = 0; i < qtyOrdered; i++)
        {
            total_cost += itemsOrdered[i].getCost();
        }
        return total_cost;
    }

    public void printCart()                                                         // Test and print DVD, total cost
    {
        for (int i = 0; i < qtyOrdered; i++)
        {
            System.out.println(itemsOrdered[i].toString());
        }
        System.out.println("Total cost is: " + totalCost());
    }

    public void findCart(int id)                                                    // find by id
    {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++)
        {
            if (id == itemsOrdered[i].getId())                                      // id start from 1
            {
                System.out.println(itemsOrdered[i].toString());
                found = true;
            }
        }
        if(!found)
            System.out.println("Could not found the " + id + " DVD.");              // print if could not found
    }

    public void findCart(String title)                                              // find by title
    {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++)
        {
            if(itemsOrdered[i].getTitle().equals(title))
            {
                System.out.println(itemsOrdered[i].toString());
                found = true;
            }
        }
        if(!found)
            System.out.println("Could not found the " + title + " DVD.");           // print if could not found

    }
}
