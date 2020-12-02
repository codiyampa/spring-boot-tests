# spring-boot-tests
Doing some tests with Spring Boot, jOOQ and Apache Kafka on Confluent Cloud.

## Installation
* You will need gradle and docker installed on your development environment

## Project purpose
We will deploy Spring into Cloud Run, doing some tests with jMeter and learn jOOQ + Apache Kafka.

## Documentation

Required commands:

`gradle flywayClean` (clean Flyway state)

`gradle generateJooq` (generate jOOQ classes)