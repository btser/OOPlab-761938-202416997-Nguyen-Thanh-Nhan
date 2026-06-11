package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    public Media(int id, String title, String category, float cost) {
        this(title, category, cost);
        this.id = id;
    }

    public boolean isMatch(String title) {
        if(title == null || this.getTitle() == null) {
            return false;
        }
        return this.getTitle().equalsIgnoreCase(title);
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        try {
            if (this == o) return true;
            if (o == null || !(o instanceof Media)) return false;
            Media other = (Media) o;
            if (this.getTitle() == null || other.getTitle() == null) {
                return false;
            }
            return this.getTitle().equalsIgnoreCase(other.getTitle()) && this.getCost() == other.getCost();
        } catch (NullPointerException | ClassCastException e) {
            return false;
        }
    }

    @Override
    public int compareTo(Media other) {
        try {
            int titleComparison = this.getTitle().compareToIgnoreCase(other.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            } else {
                return Float.compare(this.getCost(), other.getCost());
            }
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}