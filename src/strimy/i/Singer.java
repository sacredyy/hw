package strimy.i;

import java.util.ArrayList;
import java.util.List;

public class Singer {
    private String firstName;
    private String lastName;
    List<String> musics = new ArrayList<String>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Singer(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addMusicTrack(String... trackName) {
        for (String track: trackName) {
            musics.add(track);
        }
    }

    public List<String> getMusics() {
        return musics;
    }

    public void setMusics(List<String> musics) {
        this.musics = musics;
    }

}
