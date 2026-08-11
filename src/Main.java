import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        do {
            // Setting up input
            System.out.println("Enter start time");

            String startTime = input.nextLine();
            if (isValidTime(startTime) == false) {
                System.out.println("Time is not valid or in incorrect format");
                System.out.println("Exiting program");
                break;
            }

            System.out.println("Enter end time");
            String endTime = input.nextLine();
            if (isValidTime(endTime) == false) {
                System.out.println("Time is not valid or in incorrect format");
                System.out.println("Exiting program");
                break;
            }

            System.out.println("Start time " + isValidTime(startTime));
            System.out.println("End time " + isValidTime(endTime));

        } while (true);
    }


    private static final Pattern Time = Pattern.compile("^([01]\\d|2[0-3]):(00|15|30|45)$");

    public static boolean isValidTime(String time) {
        if (time == null) return false;
        return Time.matcher(time).matches();
    }

}