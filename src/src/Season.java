import java.util.ArrayList;

public class Season {

    private int seasonNumber;
    private ArrayList<Episode> episodes;

    public Season(int seasonNumber) {
        this.seasonNumber = seasonNumber;
        this.episodes = new ArrayList<>();
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }
}