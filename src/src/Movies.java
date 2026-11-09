import java.util.ArrayList;

public class Movies extends MediaType {
    private int durationMinutes;

    public Movies(String title, int releaseYear, double rating, ArrayList<String> categories) {
        super(title, releaseYear, categories, rating);

    }
       // System.out.println(getTitle() + " afspilles nu...");
}
