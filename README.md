# Temperature Service

This service simulates temperature values generated from a sensor.
It generates a values between **24** and **36** every **500 ms**.

# 1. Dependencies
The service need an instance of pulsar running in your system.
https://pulsar.apache.org/docs/en/standalone/

# 2. Build
The service was built using Gradle. You can build it with your
favorite IDE or via console (linux or OSx) with  
`./gradlew build`

# 3. Start
You can  start the application with your IDE or in the console with 
`java -jar build/libs/temperature-service-1.0-SNAPSHOT.jar`.
