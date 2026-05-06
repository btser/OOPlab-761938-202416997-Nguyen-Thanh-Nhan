package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();
    
    public Book(String title, String category, float cost){
        super(title, category, cost);
    }

    public void addAuthor(String authorName)
    {
        if (!authors.contains(authorName))
        {
            authors.add(authorName);
        }else
            System.out.println("This author has been added.");
    }

    public void removeAuthor(String authorName)
    {
        if (!authors.contains(authorName))
            System.out.println("Can not found this author.");
        else
            authors.remove(authorName);
    }
}
