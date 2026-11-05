import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Movie>watchedMovies;
    private ArrayList<Movie>savedMovies;

    public User (String username, String password) {
        this.username = username;
        this.password = password;
        this.watchedMovies = new ArrayList<>();
        this.savedMovies = new ArrayList<>();
    }


}

