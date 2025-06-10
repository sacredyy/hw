package strimy.i;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Singer s1 = new Singer("Adele", "Laurie");
        Singer s2 = new Singer("Michael ", "Jackson");
        Singer s3 = new Singer("Freddie  ", "Mercury");
        s1.addMusicTrack("Rolling in the Deep", "Someone Like You", "Hello");
        s2.addMusicTrack("Billie Jean", "Thriller", "Beat It");
        s3.addMusicTrack("Bohemian Rhapsody", "We Will Rock You", "Another One Bites the Dust");

        Singer[] singers = new Singer[]{s1, s2, s3};
        List<String> song = Arrays.stream(singers)
                .flatMap(s -> s.getMusics().stream())
                .sorted((a, b) -> a.compareTo(b))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(song);
    }
}
