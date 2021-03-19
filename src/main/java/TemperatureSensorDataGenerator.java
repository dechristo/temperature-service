import java.util.Random;

public class TemperatureSensorDataGenerator {
    private static String[] sensorNames = new String[] {
        "temperature-1b",
        "temperature-200f",
        "temperature-2m",
        "temperature-400fl"
    };
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
        return sensorNames[(int) Math.round(randomSensorNameIndex)];
    }
}