import java.util.Random;

public class TemperatureSensorDataGenerator {
    public static double generateTemperatureData() {
        int lowerBound = 24;
        int upperBound = 36;
        Random r = new Random();
        double randomTemperatureReading = lowerBound + r.nextDouble() * (upperBound - lowerBound);
        String randomReadingAsString = String.format("%2.2f", randomTemperatureReading);

        return Double.valueOf(randomReadingAsString);
    }
}