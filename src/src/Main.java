
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    private static ArrayList<Movie> movies;
    private static ArrayList<Series> series;

    public static void main(String[] args) {

        // Indlæs film og serier fra filerne
        FileIO fileIO = new FileIO();

        movies = fileIO.loadMovies("data/moviedata.csv");
        series = fileIO.loadSeries("data/SeriesData.csv");

        System.out.println("Velkommen til CHILL!");

        startMenu();

        mainMenu();
    }

    // Start menu

    public static void startMenu() {



    }

    // Hovedmenu
    public static void mainMenu() {

        boolean running = true;

        while (running) {

            System.out.println("\n===== CHILL HOVEDMENU =====");
            System.out.println("1. Søg efter film eller serie");
            System.out.println("2. Søg efter kategori");
            System.out.println("3. Se sete film");
            System.out.println("4. Se gemte film");
            System.out.println("0. Log ud");

            System.out.print("Vælg en mulighed: ");

            String choice = input.nextLine();

            switch (choice) {

                case "1":
                    searchByTitle();
                    break;

                case "2":
                    searchByCategory();
                    break;

                case "3":
                    System.out.println("Sete film kobler vi på senere.");
                    break;

                case "4":
                    System.out.println("Gemte film kobler vi på senere.");
                    break;

                case "0":
                    running = false;
                    System.out.println("Du er nu logget ud.");
                    break;

                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    // Søg efter film eller serie
    public static void searchByTitle() {

        System.out.print("Indtast titel: ");
        String search = input.nextLine().trim();

        boolean found = false;

        for (Movie movie : movies) {

            if (movie.getTitle().toLowerCase()
                    .contains(search.toLowerCase())) {

                System.out.println(movie);
                found = true;
            }
        }

        for (Series serie : series) {

            if (serie.getTitle().toLowerCase()
                    .contains(search.toLowerCase())) {

                System.out.println(serie);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Vi kunne ikke finde noget med den titel.");
        }
    }

    // Søg efter kategori
    public static void searchByCategory() {

        System.out.print("Indtast kategori: ");
        String search = input.nextLine().trim();

        boolean found = false;

        for (Movie movie : movies) {

            for (String genre : movie.getGenres()) {

                if (genre.equalsIgnoreCase(search)) {
                    System.out.println(movie);
                    found = true;
                    break;
                }
            }
        }

        for (Series serie : series) {

            for (String genre : serie.getGenres()) {

                if (genre.equalsIgnoreCase(search)) {
                    System.out.println(serie);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Vi kunne ikke finde noget i den kategori.");
        }
    }
}
