package com.curso.kafka.consumer.cursokafkaconsumer.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	static final Logger  log = LoggerFactory.getLogger(Consumer.class);
	
	@KafkaListener(topics = "curso-kafka-test",  groupId = "test-consumer-group")
	public void listenGroup(String message) {
		log.info("Mensaje en el grupo test-consumer-group {}", message);
	}
}
