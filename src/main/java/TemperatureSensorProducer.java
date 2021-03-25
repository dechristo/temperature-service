import common.TemperatureSensor;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.impl.schema.JSONSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemperatureSensorProducer {
    private PulsarClient pulsarClient;
    private Producer<TemperatureSensor> producer;
    private Logger logger;

    public TemperatureSensorProducer(PulsarClient pulsarClient) {
        this.pulsarClient = pulsarClient;
        logger = LoggerFactory.getLogger(TemperatureSensorDataGenerator.class);
    }

    public void createProducer(String topicName) {
        if (topicName.equals("")) throw new IllegalArgumentException("Producer topic name cannot be empty.");

        try {
            this.producer = this.pulsarClient.newProducer(JSONSchema.of(TemperatureSensor.class))
                .topic(topicName)
                .create();
            logger.info("Producer created successfully.");
        } catch (Exception ex) {
            logger.error("Failed to create producer: " + ex.getMessage());
        }
    }

    public void publish(TemperatureSensor data){
        try {
            producer.send(data);
            logger.info(String.format("Message sent: name=[%s] and value=[%s]", data.getName(), data.getValue()));
        } catch (Exception ex) {
            logger.error(
                String.format("Failed to publish message with name=[%s] and value=[%s]: %s", data.getName(), data.getValue(), ex.getMessage())
            );
        }
    }
}
