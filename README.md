# spring-boot-tests
Doing some tests with Spring Boot, jOOQ and Apache Kafka on Confluent Cloud.

## Installation
* You will need gradle and docker installed on your development environment

## Project purpose
We will deploy Spring into Cloud Run, doing some tests with jMeter and learn jOOQ + Apache Kafka.

## Documentation

### Development

You may need these commands:

`gradle flywayClean` (clean Flyway state)

`gradle generateJooq` (generate jOOQ classes)

### Docker

Run these commands to build the docker image:

`gradle build` (build .jar file)

`mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)` (extract files from .jar archive)

`docker build --build-arg DEPENDENCY=build/dependency -t codiyampa/spring-boot-test-docker .` (build docker image)

`docker run -p 8080:8080 codiyampa/spring-boot-test-docker` (run docker image)