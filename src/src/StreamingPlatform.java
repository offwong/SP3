import java.io.IOException;
import java.util.ArrayList;

public class StreamingPlatform {

    private static final String MOVIE_FILE = "data/moviedata.csv";
    private static final String SERIES_FILE = "data/SeriesData.csv";
    private static final String USER_FILE = "data/userData.csv";

    private TextUI ui = new TextUI();
    private ArrayList<Movies> movies = new ArrayList<>();
    private ArrayList<Series> series = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private User currentUser;


    public void run() {
        try {
            movies = FileIO.readMovies(MOVIE_FILE);
            series = FileIO.readSeries(SERIES_FILE);
            users = FileIO.readUsers(USER_FILE);
        } catch (IOException e) {
            ui.displayMessage("Kunne ikke indlæse data. Programmet lukkes.");
            return;
        }
        startMenu();
    }


    private void startMenu() {
        boolean isRunning = true;

        while (isRunning) {
            ui.displayMessage("\n=== Start menu ===");
            ui.displayMessage("1. Opret bruger");
            ui.displayMessage("2. Log ind");
            ui.displayMessage("3. Afslut");

            String choice = ui.promptText("Vælg: ");

            if (choice.equals("1")) {
                createUser();
            } else if (choice.equals("2")) {
                currentUser = login();
                if (currentUser != null) {
                    mainMenu();
                }
            } else if (choice.equals("3")) {
                isRunning = false;
                ui.displayMessage("Programmet afsluttes.");
            } else {
                ui.displayMessage("Ugyldigt valg.");
            }
        }
    }

    private void createUser() {
        String username = ui.promptText("Indtast brugernavn: ");

        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                ui.displayMessage("Brugernavnet er allerede i brug.");
                return;
            }
        }

        String password = ui.promptText("Indtast password: ");
        User newUser = new User(username, password);
        users.add(newUser);

        try {
            FileIO.saveUser(USER_FILE, newUser);
            ui.displayMessage("Bruger oprettet. Du kan nu logge ind.");
        } catch (IOException e) {
            ui.displayMessage("Der skete en fejl i oprettelsen af brugeren.");
        }
    }

    private User login() {
        String username = ui.promptText("Indtast brugernavn: ");
        String password = ui.promptText("Indtast password: ");

        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                ui.displayMessage("Login successful!");
                return user;
            }
        }
        ui.displayMessage("Forkert brugernavn eller password.");
        return null;
    }



    private void mainMenu() {
        boolean inMenu = true;

        while (inMenu) {
            ui.displayMessage("\n=== CHILL HOVEDMENU ===");
            ui.displayMessage("1. Søg efter film eller serie");
            ui.displayMessage("2. Søg efter kategori");
            ui.displayMessage("3. Se sete film");
            ui.displayMessage("4. Se gemte film");
            ui.displayMessage("0. Log ud");

            String choice = ui.promptText("Vælg: ");

            if (choice.equals("0")) {
                inMenu = false;
                currentUser = null;
                ui.displayMessage("Du er logget ud.");
            } else if (choice.equals("1")) {
                searchByTitle();
            } else if (choice.equals("2")) {
                searchByCategory();
            } else if (choice.equals("3")) {
                chooseMedia(currentUser.getWatchedMedia());
            } else if (choice.equals("4")) {
                chooseMedia(currentUser.getSavedMedia());
            } else {
                ui.displayMessage("Ugyldigt valg.");
            }
        }
    }

    private void searchByTitle() {
        String search = ui.promptText("Søg efter titel: ").toLowerCase();
        ArrayList<MediaType> results = new ArrayList<>();

        for (MediaType media : getAllMedia()) {
            if (media.getTitle().toLowerCase().contains(search)) {
                results.add(media);
            }
        }
        chooseMedia(results);
    }

    private void searchByCategory() {
        String category = ui.promptText("Indtast kategori: ").trim();
        ArrayList<MediaType> results = new ArrayList<>();

        for (MediaType media : getAllMedia()) {
            for (String mediaCategory : media.getCategory()) {
                if (category.equalsIgnoreCase(mediaCategory)) {
                    results.add(media);
                    break;
                }
            }
        }
        chooseMedia(results);
    }


    private ArrayList<MediaType> getAllMedia() {
        ArrayList<MediaType> allMedia = new ArrayList<>();
        allMedia.addAll(movies);
        allMedia.addAll(series);
        return allMedia;
    }


    private void chooseMedia(ArrayList<MediaType> list) {
        if (list.isEmpty()) {
            ui.displayMessage("Listen er tom.");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            ui.displayMessage((i + 1) + ". " + list.get(i));
        }
        ui.displayMessage("0. Tilbage");

        int choice = ui.promptNumeric("Vælg et nummer: ");

        if (choice == 0) {
            return;
        }
        if (choice < 1 || choice > list.size()) {
            ui.displayMessage("Ugyldigt nummer.");
            return;
        }

        MediaType media = list.get(choice - 1);

        ui.displayMessage("\nDu har valgt: " + media);
        ui.displayMessage("1. Afspil");
        ui.displayMessage("2. Gem til senere");
        ui.displayMessage("3. Fjern fra gemte");
        ui.displayMessage("0. Tilbage");

        String action = ui.promptText("Vælg: ");

        if (action.equals("1")) {
            media.play();
            currentUser.addWatchedMedia(media);
        } else if (action.equals("2")) {
            currentUser.addSavedMedia(media);
            ui.displayMessage(media.getTitle() + " er gemt til senere.");
        } else if (action.equals("3")) {
            currentUser.removeSavedMedia(media);
            ui.displayMessage(media.getTitle() + " er fjernet fra gemte.");
        }
    }
}
