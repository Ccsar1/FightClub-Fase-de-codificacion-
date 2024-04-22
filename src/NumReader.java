import java.util.Scanner;

public class NumReader {
    private static boolean isNumeric(String input) {

        boolean result;

        try {
            Integer.parseInt(input);
            result = true;
        } catch (NumberFormatException exception) {
            result = false;
        }

        return result;
    }

    public static int readNumber() {

        Scanner scan = new Scanner(System.in);

        int num = -1;

        do {
            String input = scan.nextLine();
            if (isNumeric(input)) {
                num = Integer.parseInt(input);
                if (num < 0) {
                    System.out.println("Please write a positive number");
                }
            } else {
                System.out.println("Please write a positive number");
            }
        } while (num < 0);

        return num;
    }
}
