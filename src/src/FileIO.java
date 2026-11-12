import java.io.*;
import java.util.ArrayList;

public class FileIO {

    public static ArrayList<Movies> readMovies(String path) throws IOException{
        ArrayList<Movies> movies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(";");
                String title = parts[0].trim();
                int year = Integer.parseInt(parts[1].trim());
                double rating = Double.parseDouble(parts[3].trim().replace(",", "."));
                ArrayList<String> categories = new ArrayList<>();
                for (String category : parts[2].split(",")) {
                    categories.add(category.trim());
                }
                movies.add(new Movies(title, year, rating, categories));
            }
        } return movies;

    }

    public static ArrayList<Series> readSeries(String path) throws IOException {
        ArrayList<Series> series = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(";");
                String title = parts[0].trim();
                int startYear = Integer.parseInt(parts[1].trim().split(("-"))[0]);
                double rating = Double.parseDouble(parts[3].trim().replace(",", "."));
                ArrayList<String> categories = new ArrayList<>();
                for (String category : parts[2].split(",")) {
                    categories.add(category.trim());
                }
                Series newSeries = new Series(title, startYear, categories, rating);
                for (String seasonText : parts[4].split(",")) {
                    String[] seasonParts = seasonText.trim().split("-");
                    int seasonNumber = Integer.parseInt(seasonParts[0]);
                    int episodeCount = Integer.parseInt(seasonParts[1]);
                    Season season = new Season(seasonNumber);
                    for (int i = 1; i <= episodeCount; i++) {
                        season.addEpisode(new Episode(i));
                    }
                    newSeries.addSeason(season);
                }
                series.add(newSeries);

            }
        }
        return series;
    }

    public static ArrayList<User> readUsers(String path) throws IOException {
        ArrayList<User> users = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) return users; // første gang programmet kører

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new User(parts[0], parts[1]));
                }
            }
        }
        return users;
    }

    public static void saveUser(String path, User user) throws IOException {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(user.getUsername() + "," + user.getPassword() + "\n");
        }
    }
}

