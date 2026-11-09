import java.util.Scanner;



public class TextUI {
    Scanner scan = new Scanner(System.in);

    public String promptText(String msg){
        System.out.println(msg);
        String input = scan.nextLine();
        return input;
    }


    public void displayMessage(String msg){
        System.out.println(msg);
    }

    public boolean promptBinary(String msg) {
        System.out.println(msg);
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            return true;
        } else if (input.equalsIgnoreCase("N")) {
            return false;
        } else return promptBinary(msg);


    }


}
