package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SensorNamesTest {

    @Test
    public void shouldContainsValidSensorNames() {
        assertEquals(SensorNames.getSensorNames().size(), 4);
        assertTrue(SensorNames.getSensorNames().contains("temperature-1b"));
        assertTrue(SensorNames.getSensorNames().contains("temperature-2m"));
        assertTrue(SensorNames.getSensorNames().contains("temperature-400fl"));
        assertTrue(SensorNames.getSensorNames().contains("temperature-200f"));
    }
}
