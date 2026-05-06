package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc{

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(String title) {
        super(title);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director,cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    public String toString()
    {
        return "DVD - " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + "$" ;
    }
}
