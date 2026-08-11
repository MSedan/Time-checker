import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int option;
        do {
            // Setting up input
            System.out.println("Aktsepteeritavad kellaajad on 24-tunni süsteemis: HH:00, HH:15, HH:30, HH:45");
            System.out.println("Palun sisestage alguskellaaeg");

            String startTime = input.nextLine();
            if (isValidTime(startTime) == false) {
                System.out.println("Sisestatud aeg ei ole korrektne");
                System.out.println("Programmist väljumine.");
                break;
            }

            System.out.println("Sisestage lõppkellaaeg");
            String endTime = input.nextLine();
            if (isValidTime(endTime) == false) {
                System.out.println("Sisestatud aeg ei ole korrektne.");
                System.out.println("Programmist väljumine");
                break;
            }

           // System.out.println("Day time " + dayMinutes + " minutes " + nightMinutes); - used for checking if the minutes are correct

            double [] dayNightArray = calculateTime(startTime, endTime);
            //Printing final output for the user.
            System.out.println("Päev: " + dayNightArray[0]);
            System.out.println("Öö: " + dayNightArray[1]);

            System.out.println("Kui soovid sisestada veel kellaaegu, vali 1 \n" + "Programmist väljumiseks vali 0");
            System.out.println("Sisesta valik:");
            option = input.nextInt();
            input.nextLine();

        } while (option != 0);
    }

    //Checking input with regex
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

    public static double[] calculateTime(String startTime, String endTime) {
        int dayStart = 6 * 60; // Setting minutes for 06:00
        int dayEnd = 22 * 60; // Setting minutes for 22:00

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
        double dayHours = dayMinutes / 60.0;
        double nightHours = nightMinutes / 60.0;

        return new double[]{dayHours, nightHours};
    }
}