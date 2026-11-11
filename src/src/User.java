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
    public void addWatchedMovie (Movie movie) {
        if (!savedMovies.contains(movie)){
            savedMovies.add(movie);
        }
    }


    public String getUsername(){
        return this.username;
    }


    public String getPassword(){
        return this.password;
    }



}

