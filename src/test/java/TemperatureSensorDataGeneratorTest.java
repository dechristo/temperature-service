import org.junit.Test;
import utils.SensorNames;
import static org.junit.Assert.assertTrue;

public class TemperatureSensorDataGeneratorTest {

    @Test
    public void shouldGenerateOnlyValuesBetween24and36() {
        for (int index = 0; index < 10000; index++) {
            double value = TemperatureSensorDataGenerator.generateTemperatureData();
            assertTrue(value >= 24 && value <= 36);
        }
    }

    @Test
    public void shouldGenerateValidSensorNames() {
        for (int index = 0; index < 10000; index++) {
            String name = TemperatureSensorDataGenerator.generateSensorName();
            assertTrue(SensorNames.getSensorNames().contains(name));
        }
    }
}
