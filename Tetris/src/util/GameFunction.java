package util;

public class GameFunction {

    public static long getSleepTimeByLevel(int level) {
        long sleepTime = (-100 * level + 1500);
        sleepTime = sleepTime < 100 ? 100 : sleepTime;
        return sleepTime;
    }
}
