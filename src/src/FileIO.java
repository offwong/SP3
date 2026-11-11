import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public static ArrayList<Movies>










}

    /*public ArrayList<Movie> loadMovies(String filePath) {
        ArrayList<Movie> movies = new ArrayList<>();

        // Brug try-with-resources for at lukke scanneren automatisk
        try (Scanner scan = new Scanner(new File(filePath))) {

            // Valgfrit: Hvis din CSV-fil har en header-linje (f.eks. "Title;Year;..."),
            // kan du springe den over ved at udkommentere linjen herunder:
            // if (scan.hasNextLine()) { scan.nextLine(); }

            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                // Spring over tomme linjer
                if (line.isEmpty()) {
                    continue;
                }
                // 1. Split linjen op på semikolon
                String[] values = line.split(";");

                String title = values[0].trim();
                int releaseYear = Integer.parseInt(values[1].trim());

                // 2. Håndter genrer (split op på komma og læg i en ArrayList)
                String genreString = values[2].trim();
                String[] genreArray = genreString.split(",");
                ArrayList<String> genres = new ArrayList<>();
                for (String g : genreArray) {
                    genres.add(g.trim());
                }
                String ratingStr = values[3].trim().replace(",", ".");
                double rating = Double.parseDouble(ratingStr);

                // 3. Opret et nyt Movie-objekt og tilføj det til listen
                Movie movie = new Movie(title, releaseYear, genres, rating);
                movies.add(movie);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fejl: Kunne ikke finde film-filen på stien: " + filePath);
        } catch (NumberFormatException e) {
            System.out.println("Fejl: Noget data kunne ikke konverteres til tal (tjek årstal eller rating).");
        }

        return movies;
    }

    public ArrayList<Series> loadSeries(String filePath) {
        ArrayList<Series> seriesList = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(filePath))) {

            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                String[] values = line.split(";");
                String title = values[0].trim();
                String releaseYears = values[1].trim();

                // 2. Håndter genrer
                String genreString = values[2].trim();
                String[] genreArray = genreString.split(",");
                ArrayList<String> genres = new ArrayList<>();
                for (String g : genreArray) {
                    genres.add(g.trim());
                }

                // 3. Håndter rating (erstatter dansk komma med punktum)
                String ratingStr = values[3].trim().replace(",", ".");
                double rating = Double.parseDouble(ratingStr);

                // 4. Håndter sæsoner og generer episoder (f.eks. "1-8, 2-22")
                String seasonsString = values[4].trim();
                String[] seasonArray = seasonsString.split(",");
                ArrayList<Season> seasons = new ArrayList<>();

                for (String s : seasonArray) {
                    String[] seasonParts = s.trim().split("-");
                    int seasonNumber = Integer.parseInt(seasonParts[0].trim());
                    int episodeCount = Integer.parseInt(seasonParts[1].trim());

                    // Opret en liste af episoder for denne sæson
                    ArrayList<Episode> episodes = new ArrayList<>();
                    for (int i = 1; i <= episodeCount; i++) {
                        episodes.add(new Episode(i));
                    }

                    // Tilføj sæsonen med dens episoder til sæson-listen
                    seasons.add(new Season(seasonNumber, episodes));
                }

                // 5. Opret Series-objektet og tilføj til listen
                Series series = new Series(title, releaseYears, genres, rating, seasons);
                seriesList.add(series);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fejl: Kunne ikke finde serie-filen på stien: " + filePath);
        } catch (NumberFormatException e) {
            System.out.println("Fejl: Noget data kunne ikke konverteres til tal.");
        }

        return seriesList;
    }

    private static ArrayList<Genre> readCategories(String data) {

        ArrayList<Genre> genres = new ArrayList<>();

        String[] categories = data.split(",");

        for (String category : categories) {

            String name = category.trim()
                    .toUpperCase()
                    .replace("-", "_");

            genres.add(Genre.valueOf(name));
        }

        return genres;
    }


}*/
