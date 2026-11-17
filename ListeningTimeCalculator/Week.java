package ListeningTimeCalculator;
import java.time.*;

/**
 * Stores the information for a week of music listened 
 * to that will be stored in the weeks.txt file via the
 * ListeningTimeCalculator class
 * 
 * @author Ethan Perkins
 * @version 0.1 - Nov 16, 2026
 */

public class Week {
    private LocalDate weekStart;
    private int minutesListened;

    /**
     * Creates a Week object and defines all properties and values
     * required for the week to be documented for the rest of the
     * program.
     * 
     * @param year year of the start of the week
     * @param month month of the start of the week
     * @param day day of the start of the week
     * @param minutesListened minutes listened to music this week
     * @throws InvalidDayException errors if starting day is not a Monday
     */
    public Week(int year, int month, int day, int minutesListened) throws InvalidDayException {
        isMonday(LocalDate.of(year, month, day));
        this.weekStart = LocalDate.of(year, month, day);
        this.minutesListened = minutesListened;
    }

    /**
     * Creates a Week object without defining the amount of minutes
     * listened to music that week, sets minutesListened to -1.
     * 
     * @param year year of the start of the week
     * @param month month of the start of the week
     * @param day day of the start of the week
     * @throws InvalidDayException errors if starting day is not a Monday
     */
    public Week(int year, int month, int day) throws InvalidDayException {
        isMonday(LocalDate.of(year, month, day));
        this.weekStart = LocalDate.of(year, month, day);
        minutesListened = -1;
    }

    /**
     * Gets the LocalDate object of the start of the week.
     * 
     * @return the start of the week
     */
    public LocalDate getDate() {
        return weekStart;
    }

    /**
     * Gets the amount of minutes listened to music this week.
     * 
     * @return the amount of minutes listened to this week (-1 if undefined)
     */
    public int getMinutesListened() {
        return minutesListened;
    }

    /**
     * Determines if this week takes place chronologically before the
     * other week inputted.
     * 
     * @param week the Week being compared to this week
     * @return true if this week happens chronologically before the other week, otherwise false
     */
    public boolean isBefore(Week week) {
        if (this.weekStart.isBefore(week.getDate())) {
            return true;
        }
        return false;
    }

    /**
     * Throws an InvalidDayException when the LocalDate inputted
     * is not a Monday, the first day of the week.
     * 
     * @param date LocalDate being checked
     * @throws InvalidDayException thrown if date is not a Monday
     */
    public void isMonday(LocalDate date) throws InvalidDayException {
        if (date.getDayOfWeek().getValue() != 1) {
            throw new InvalidDayException("The starting day inputted was not a Monday.");
        }
    }

    /**
     * Determines if this week has a higher minutesListened value
     * than that of the parameter week.
     * 
     * @param week the Week being compared to this week
     * @return true if this minutesListened is greater than that of the parameter Week
     */
    public boolean listenedMoreThan(Week week) {
        return this.minutesListened > week.getMinutesListened();
    }

    /**
     * Sets the minutesListened field to whatever is passed as an
     * argument.
     * 
     * @param minutesListened minutes listened to music this week
     */
    public void setMinutesListened(int minutesListened) {
        this.minutesListened = minutesListened;
    }

    @Override 
    public String toString() {
        String result = String.format("%d/%d/%d", weekStart.getMonthValue(), weekStart.getDayOfMonth(), weekStart.getYear());
        if (minutesListened >= 0) {
            result += " - " + minutesListened + " mins";
        }
        return result;
    }
}
