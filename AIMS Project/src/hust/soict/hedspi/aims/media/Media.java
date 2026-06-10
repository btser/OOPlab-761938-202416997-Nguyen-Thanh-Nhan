package hust.soict.hedspi.aims.media;

import java.security.PublicKey;

public abstract class Media {
    public int id;
    public String title;
    public String category;
    public float cost;
    
    public Media(String title, String category, float cost) 
    {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public Media(String title)
    {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }
}
