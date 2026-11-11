public class Episode {
    private int episodeNumber;

    public Episode(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    @Override
    public String toString() {
        return "Afsnit " + episodeNumber;
    }
}