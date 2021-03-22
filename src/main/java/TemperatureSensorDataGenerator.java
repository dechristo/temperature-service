import java.util.Random;
import utils.SensorNames;

public class TemperatureSensorDataGenerator {
    public static double generateTemperatureData() {
        int lowerBound = 24;
        int upperBound = 36;
        Random r = new Random();
        double randomTemperatureReading = lowerBound + r.nextDouble() * (upperBound - lowerBound);
        String randomReadingAsString = String.format("%2.2f", randomTemperatureReading);

        return Double.valueOf(randomReadingAsString);
    }

    public static String generateSensorName() {
        int lowerBound = 0;
        int upperBound = 3;
        Random r = new Random();
        double randomSensorNameIndex = lowerBound + r.nextDouble() * (upperBound - lowerBound);
        return SensorNames.getSensorNames().get((int) Math.round(randomSensorNameIndex));
    }
}