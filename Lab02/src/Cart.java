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
}
