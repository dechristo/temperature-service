import java.util.Random;

public class TemperatureSensorDataGenerator {
    public static double generateTemperatureData() {
        int lowerBound = 24;
        int upperBound = 36;
        Random r = new Random();
        double random = lowerBound + r.nextDouble() * (upperBound - lowerBound);
        return random;
    }
}