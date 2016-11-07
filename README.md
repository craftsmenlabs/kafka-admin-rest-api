# Kafka Admin REST API

[![Build Status](https://travis-ci.org/craftsmenlabs/kafka-admin-rest-api.svg?branch=master)](https://travis-ci.org/craftsmenlabs/kafka-admin-rest-api)


This rest api allows for adminstration of a kafka cluster.

## Usage

To build the admin api

```bash
mvn clean install
```
Running the application

```bash
docker run -p 8080:8080 -e ZOOKEEPER_URLS=localhost:2181 craftsmenlabs/kakfa-admin-rest-api
```

Create a topic (example)

```bash
curl -X POST http://localhost:8080/topic -H 'Content-Type: application/json' -d '{"name":"something10","partitions":1,"replications":1,"properties":{"cleanup.policy":"compact"}}'
```

Example request body
```json
{
    "name": "something9",
    "partitions": 1,
    "replications": 1,
    "properties": {
        "cleanup.policy": "compact"
    }
}
```
