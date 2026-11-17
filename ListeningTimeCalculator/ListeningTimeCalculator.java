package ListeningTimeCalculator;

import java.util.ArrayList;

/**
 * An application that tracks and stores weeks of music listening
 * data in minutes that is inputted by the user.
 * 
 * @author Ethan Perkins
 * @version 0.1 - Nov 16, 2026
 */

public class ListeningTimeCalculator {
    private int MINUTES_PER_WEEK = 10080;
    private static int totalListeningTime = 0;
    private static ArrayList<ListenWeek> weeks = new ArrayList<ListenWeek>();
    private static boolean running = true;


    public static void calculateTotalListeningTime(ListenWeek[] weeks) {
        int localTotal = 0;
        for (int i = 0; i < weeks.length; i++) {
            localTotal += weeks[i].getMinutesListened();
        }
        totalListeningTime = localTotal;
    }

    public static void main(String[] args) {
        while (running) {
            calculateTotalListeningTime(weeks.toArray(new ListenWeek[0]));
            // clears the terminal, temporary for terminal access
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            IO.println("------------------------------------");
            IO.println("Music Listening Time Calculator");
            IO.println("------------------------------------");
            IO.println("Total Minutes Listened: " + totalListeningTime);
            if (weeks.size() > 0)
                IO.println("Most Recently Added Week: " + weeks.getLast());
            IO.println("------------------------------------");
            IO.println("Select, invalid selection will exit.");
            
            IO.println(" 1. Add Week");
            
            int choice = -1;

            try {
                choice = Integer.parseInt(IO.readln("--> "));
                if (choice == 1) {
                    String[] date = IO.readln("Date as String (m/d/y) --> ").split("/");
                    weeks.add(new ListenWeek(
                        Integer.parseInt(date[2]), 
                        Integer.parseInt(date[0]), 
                        Integer.parseInt(date[1])
                    ));
                    int mins = Integer.parseInt(IO.readln("Minutes Listened --> "));
                    weeks.getLast().setMinutesListened(mins);
                    IO.println("Week '" + weeks.getLast() + "' successfully added!");
                } else {
                    IO.println("Invalid choice. Process failed.");
                    running = false;
                }
            } catch (Exception e) {
                IO.println("Invalid value. Process failed.");
                running = false;
            }
        }
    }
}