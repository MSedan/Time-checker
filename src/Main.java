import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {

        // Setting up input
        System.out.println("Enter start time");
        Scanner input = new Scanner(System.in);
        String startTime = input.nextLine();
        System.out.println("Enter end time");
        String endTime = input.nextLine();

        System.out.println("Start time " + isValidTime(startTime));
        System.out.println("Start time " + isValidTime(endTime));
    }


    private static final Pattern Time = Pattern.compile("^([01]\\d|2[0-3]):(00|15|30|45)$");

    public static boolean isValidTime(String time) {
        if (time == null) return false;
        return Time.matcher(time).matches();
    }
}