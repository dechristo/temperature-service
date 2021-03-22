import org.apache.pulsar.client.api.PulsarClient;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

public class TemperatureSensorProducerTest {
    private static TemperatureSensorProducer temperatureSensorProducer;
    private static PulsarClient pulsarClientMock;

    @BeforeAll
    public static void setUp() {
        pulsarClientMock = mock(PulsarClient.class);
        temperatureSensorProducer = new TemperatureSensorProducer(pulsarClientMock);
    }

    @Test
    public void shouldThrowExceptionForEmptyProducerName(){
        assertThrows(Exception.class, () -> {
            temperatureSensorProducer.createProducer("");
        });
    }

    @Test
    public void shouldCallProducerOneTime() {
        temperatureSensorProducer.createProducer("whatacooltopicname");
        Mockito.verify(pulsarClientMock, Mockito.times(1))
            .newProducer(any());
    }
}
