# spring-kafka-consumer
Show cases consuming messages from Apache Kafka.

First we need to run Zookeeper and Kafka.
Change to bin directory of Kafka and run zookeeper:

./zookeeper-server-start.sh ../config/zookeeper.properties

then we need to run Kafka:

./kafka-server-start.sh ../config/server.properties


Now we are able to run consumer application which consumes messages from event topic.


