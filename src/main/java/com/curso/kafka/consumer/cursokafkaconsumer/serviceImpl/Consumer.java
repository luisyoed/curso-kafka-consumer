package com.curso.kafka.consumer.cursokafkaconsumer.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.annotation.PartitionOffset;

@Service
public class Consumer {
	static final Logger log = LoggerFactory.getLogger(Consumer.class);

//	@KafkaListener(topics = "curso-kafka-test-3", groupId = "test-consumer-group")
//	public void listenGroup(String message) {
//		log.info("Mensaje en el grupo test-consumer-group {} ", message);
//	}

//	@KafkaListener(topics = "curso-kafka-test-3", groupId = "test-consumer-group")
//	public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//		log.info("Received Message: {}, from partition:{} ", message, partition);
//	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = "curso-kafka-test-3" , partitionOffsets = {
			@PartitionOffset(partition = "0", initialOffset = "0"),
			@PartitionOffset(partition = "1", initialOffset = "0"),
			@PartitionOffset(partition = "2", initialOffset = "0") }), groupId = "cursokafka3", containerFactory = "partitionsKafkaListenerContainerFactory")
	public void listenToPartition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
		log.info("Received Message: {}, from partition:{} ", message, partition);
	}
}
