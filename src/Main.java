import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dayStart = 6 * 60; // Setting minutes for 06:00
        int dayEnd = 22 * 60; // Setting minutes for 22:00

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

            int[] start = getTime(startTime);
            int[] end = getTime(endTime);

            int startTotal = start[0] * 60 + start[1];
            int endTotal = end[0] * 60 + end[1];

            if (endTotal <= startTotal) {
                endTotal += 24 * 60;
            }

            int dayMinutes = 0;
            int nightMinutes = 0;

            for (int i = startTotal; i < endTotal; i++) {
                int minuteOfDay = i % (24 * 60);
                if (minuteOfDay >= dayStart && minuteOfDay < dayEnd) {
                    dayMinutes++;
                } else {
                    nightMinutes++;
                }
            }
            int dayHours = dayMinutes / 60;
            int dayMins = dayMinutes % 60;
            int nightHours = nightMinutes / 60;
            int nightMins = nightMinutes % 60;

            System.out.println("Start time " + isValidTime(startTime));
            System.out.println("End time " + isValidTime(endTime));
           // System.out.println("Day time " + dayMinutes + " minutes " + nightMinutes); - used for checking if the minutes are correct

            //Printing final output for the user.
            System.out.println("Daytime hours: " + dayHours + " h " + dayMins + " min");
            System.out.println("Nighttime hours: " + nightHours + " h " + nightMins + " min");
        } while (true);
    }


    private static final Pattern Time = Pattern.compile("^([01]\\d|2[0-3]):(00|15|30|45)$");

    public static boolean isValidTime(String time) {
        if (time == null) return false;
        return Time.matcher(time.trim()).matches();
    }

    public static int[] getTime(String time) {
        //Creating an array for the time entered to split it into hours and minutes.
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        return new int[]{hour, minute};
    }
}