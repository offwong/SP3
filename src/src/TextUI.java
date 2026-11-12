import java.util.Scanner;

public class TextUI {
    private Scanner scan = new Scanner(System.in);

    public String promptText(String msg) {
        System.out.print(msg);
        return scan.nextLine();
    }

    public int promptNumeric(String msg) {
        while (true) {
            String input = promptText(msg);
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                displayMessage("Skriv venligst et tal.");
            }
        }
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    public boolean promptBinary(String msg) {
        String input = promptText(msg);
        if (input.equalsIgnoreCase("Y")) {
            return true;
        } else if (input.equalsIgnoreCase("N")) {
            return false;
        } else {
            return promptBinary(msg);
        }
    }
}
