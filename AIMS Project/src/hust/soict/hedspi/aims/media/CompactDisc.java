package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    private static int nbCompactDisc = 0;

    public CompactDisc(String title, String category, String director,int length, float cost, String artist)
    {
        super(title, category, director, length, cost);
        this.artist = artist;
        nbCompactDisc++;
        this.setId(nbCompactDisc);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track)
    {
        if (!tracks.contains(track))
        {
            tracks.add(track);
            System.out.println("The track has been added successfully");
        }else{
            System.out.println("This track already existed");
        }
    }

    public void removeTrack(Track track)
    {
        if (tracks.contains(track))
        {
            tracks.remove(track);
            System.out.println("The track has been removed successfully");
        }else{
            System.out.println("This track doesn't exist");
        }
    }

    public int getLength(){
        int totalLength = 0;

        for (Track track : tracks)
        {
            totalLength += track.getLength();
        }

        return totalLength;
    }
}
