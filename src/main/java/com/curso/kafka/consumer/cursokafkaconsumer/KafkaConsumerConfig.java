package com.curso.kafka.consumer.cursokafkaconsumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	static final Logger log = LoggerFactory.getLogger(KafkaConsumerConfig.class);

//	@Bean
//	public ConsumerFactory<String, String> consumerFactory() {
//		Map<String, Object> props = new HashMap<>();
//		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092, localhost:9093, localhost:9094");
//		props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
//		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
//
//		return new DefaultKafkaConsumerFactory<>(props);
//	}
//
//	@Bean
//	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//		factory.setConsumerFactory(consumerFactory());
//		return factory;
//	}


	
	
	
	 @Bean
	public ConsumerFactory<String, String> consumerFactory(String groupId) {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092, localhost:9093, localhost:9094");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(String groupId) {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory(groupId));
		return factory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> partitionsKafkaListenerContainerFactory() {
		return kafkaListenerContainerFactory("partitions");
	}
	 
}
