package test;

import main.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // Testing if all correct inputs get correctly validated with regex.
    @Test
    void validTimeAccepted() {
    assertTrue(Main.isValidTime("00:00"));
    assertTrue(Main.isValidTime("20:15"));
    assertTrue(Main.isValidTime("19:30"));
    assertTrue(Main.isValidTime("04:45"));
    }

    // Testing if invalid inputs get rejected.
    @Test
    void invalidTimeRejected() {
        assertFalse(Main.isValidTime("00:12"));
        assertFalse(Main.isValidTime("20:20"));
        assertFalse(Main.isValidTime("49:30"));

    }

    // Testing edge cases
    @Test
    void invalidTimeEdgeRejected() {
        assertFalse(Main.isValidTime("9:30"));
        assertFalse(Main.isValidTime("24:00"));
        assertFalse(Main.isValidTime(""));
    }

    // Testing if day time gets calculated correctly
    @Test
    void calculateTimeAllDay() {
        double [] result = Main.calculateTime("06:00", "10:00");
        assertArrayEquals(new double[]{4.0, 0.0}, result, 0.001);
    }

    // Testing if night time gets calculated correctly
    @Test
    void calculateTimeAllNight() {
        double [] result = Main.calculateTime("23:00", "02:15");
        assertArrayEquals(new double[]{0.0, 3.25}, result, 0.001);
    }

    // Testing if time is across day and night time.
    @Test
    void calculateTimeDayAndNight() {
        double [] result = Main.calculateTime("21:15", "23:45");
        assertArrayEquals(new double[]{0.75, 1.75}, result, 0.001);
    }

    // Testing full 24h cycle
    @Test
    void calculateFullDayAndNight() {
        double [] result = Main.calculateTime("00:00", "00:00" );
            assertArrayEquals(new double[]{16.0, 8.0}, result, 0.001);
    }

    // Testing if times get parsed correctly.
    @Test
    void timeParsesCorrectly() {
        assertArrayEquals(new int[]{6, 30}, Main.getTime("06:30"));
    }
}
