package ListeningTimeCalculator;

/**
 * An application that tracks and stores weeks of music listening
 * data in minutes that is inputted by the user.
 * 
 * @author Ethan Perkins
 * @version 0.1 - Nov 16, 2026
 */

public class ListeningTimeCalculator {
    private int MINUTES_PER_WEEK = 10080;
    private int totalListeningTime;
    private int[] weeklyListeningTimes;
    private static boolean running = true;

    public static void main(String[] args) {
        while (running) {
            try {
                Week week = new Week(2026, 11, 16);
                IO.println(week);
            } catch (InvalidDayException e) {
                IO.println(e.getMessage());
            }
            running = false;
        }
    }
}