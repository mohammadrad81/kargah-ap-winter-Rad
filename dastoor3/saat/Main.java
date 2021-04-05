
import java.lang.*;


/**
 * this main takes the time from the system
 * and continues it
 * prints the time for every second
 */


public class Main {

    private static ClockDisplay clock = new ClockDisplay();

    public static void main(String[] args) throws InterruptedException {
        int hour , minute , second;

        hour = java.time.LocalTime.now().getHour();
        minute = java.time.LocalTime.now().getMinute();
        second = java.time.LocalTime.now().getSecond();

        clock.setTime(hour , minute , second);

        while (true){
            System.out.println(clock.getTime());
            clock.timeTick();
            Thread.sleep(1000);
        }
    }
}
