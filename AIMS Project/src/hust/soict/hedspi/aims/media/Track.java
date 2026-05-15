package hust.soict.hedspi.aims.media;

import java.security.PublicKey;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length)
    {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    public void play()
    {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("Track length: " + getLength());
    }

    @Override
    public boolean equals (Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return length == track.length && (title != null && title.equalsIgnoreCase(track.title));
    }
}