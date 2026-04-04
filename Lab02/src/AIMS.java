public class AIMS {

    public static void main(String[] args)
    {
        Cart newOrder = new Cart();
        DigitalVideoDisc disc_1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        newOrder.addDigitalVideoDisc(disc_1);
        DigitalVideoDisc disc_2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        newOrder.addDigitalVideoDisc(disc_2);
        DigitalVideoDisc disc_3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        newOrder.addDigitalVideoDisc(disc_3);
        System.out.print("Total cost is: ");
        System.out.println(newOrder.totalCost());
    }
}