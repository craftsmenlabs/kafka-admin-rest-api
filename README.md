# Kafka Admin REST API

This rest api allows for adminstration of a kafka cluster.

## Usage

To build the admin api

```bash
mvn clean install
```
Running the application

```bash
docker run -e ZOOKEEPER_URLS=localhost:2181 craftsmenlabs/kakfa-admin-rest-api
```




