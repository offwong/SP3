import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<MediaType> watchedMedia;
    private ArrayList<MediaType> savedMedia;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.watchedMedia = new ArrayList<>();
        this.savedMedia = new ArrayList<>();
    }

    public void addWatchedMedia(MediaType media) {
        if (!watchedMedia.contains(media)) {
            watchedMedia.add(media);
        }
    }

    public void addSavedMedia(MediaType media) {
        if (!savedMedia.contains(media)) {
            savedMedia.add(media);
        }
    }

    public void removeSavedMedia(MediaType media) {
        savedMedia.remove(media);
    }

    public ArrayList<MediaType> getWatchedMedia() {
        return watchedMedia;
    }

    public ArrayList<MediaType> getSavedMedia() {
        return savedMedia;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
