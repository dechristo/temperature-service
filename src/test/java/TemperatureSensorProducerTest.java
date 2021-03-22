import common.TemperatureSensor;
import org.apache.pulsar.client.api.PulsarClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class TemperatureSensorProducerTest {

    @Test
    public void shouldCallProducerOneTime() {
        PulsarClient pulsarClient = mock(PulsarClient.class);
        TemperatureSensorProducer temperatureSensorProducerMock = Mockito.mock(TemperatureSensorProducer.class);
        temperatureSensorProducerMock.createProducer("whatacooltopicname");
        Mockito.verify(temperatureSensorProducerMock, Mockito.times(1)).createProducer("whatacooltopicname");
    }
}
