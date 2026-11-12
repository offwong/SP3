import java.util.ArrayList;

public class Series extends MediaType {

    private ArrayList<Season> seasons;

    public Series(String title, int startYear, ArrayList<String> genres, double rating) {
        super(title, startYear, genres, rating);
        seasons = new ArrayList<>();
    }

    public void addSeason(Season season) {
        seasons.add(season);
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    @Override
    public void play(){
        System.out.println(getTitle() + " afspilles nu... (" + seasons.size() + " sæsoner)");
    }
}