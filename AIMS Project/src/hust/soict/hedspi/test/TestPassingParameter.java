package hust.soict.hedspi.test;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Track;
import java.util.ArrayList;
import java.util.List;

public class TestPassingParameter {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

                        // Example data for test, print out 3 types of media

        Book book = new Book("Byaku ya ko", "Mystery", 148000);
        DigitalVideoDisc dvd = new DigitalVideoDisc("Your Name","Mystery", "Shinkai Makoto", 6180, 199000);
        CompactDisc cd = new CompactDisc("The garden of words", "Slice of life", "Shinkai Makoto",2700, 133000, "Shinkai");
    
        Track t1 = new Track("Track 1", 2700);          // add total length trong class CompactDisc, vì hàm tính totalLength override nên ko lưu length = 2700 từ hàm gọi trên
        cd.addTrack(t1);

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        //swap(jungleDVD, cinderellaDVD);
        //System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        //System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        //changeTitle(jungleDVD, cinderellaDVD.getTitle());
        //System.out.println("jungle dvd title: " + jungleDVD.getTitle());

        mediae.add(book);
        mediae.add(dvd);
        mediae.add(cd);

        for (Media m : mediae)
        {
            System.out.println(m);
        }
    }

    public static void swap(Object o1, Object o2) {                                 // Example code
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {            // Example to changeTitle
        String oldTitle = dvd.getTitle();                                           // Update: Cannot be used
        //dvd.setTitle(title); 
        dvd = new DigitalVideoDisc(oldTitle);
    }   


}