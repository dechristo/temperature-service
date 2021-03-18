import common.TemperatureSensor;
import org.apache.pulsar.client.api.PulsarClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class App {
    private Logger logger;
    private TemperatureSensorProducer temperatureSensorProducer;
    private final static String PULSAR_URL = "pulsar://localhost:6650";
    private final static String TEMPERATURE_SENSOR_TOPIC = "temperature-sensor-1a";


    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public void start() {
        logger = LoggerFactory.getLogger(TemperatureSensorDataGenerator.class);

        try {
            PulsarClient pulsarClient = this.createPulsarClient(PULSAR_URL);
            this.temperatureSensorProducer = new TemperatureSensorProducer(pulsarClient);
            this.temperatureSensorProducer.createProducer(TEMPERATURE_SENSOR_TOPIC);

            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    TemperatureSensor data = new TemperatureSensor(
                        "sensor-1a",
                        TemperatureSensorDataGenerator.generateTemperatureData()
                    );
                    logger.info(String.format("%s : sensor=[%s], value=[%s]", new Date(data.getDatetime()), data.getName(), data.getValue()));
                    this.temperatureSensorProducer.publish(data);
                } catch (Exception ex) {
                    logger.error("Error acquiring temperature value: " + ex.getMessage());
                }
            }
        } catch (Exception ex) {
            logger.error("Error starting the application: " + ex.getMessage());
        }
    }

    public PulsarClient createPulsarClient(String url) throws Exception {
        if (url.equals("")) throw new IllegalArgumentException("Pulsar url cannot be empty.");

        try {
            PulsarClient pulsarClient = PulsarClient.builder()
                .serviceUrl(url)
                .build();
            logger.info("Pulsar client created successfully.");
            return pulsarClient;
        }
        catch (Exception ex) {
            logger.error("Error creating Pulsar client: " + ex.getMessage());
            throw ex;
        }
    }
}
