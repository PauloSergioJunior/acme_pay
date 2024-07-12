package br.com.acmePay.adapters.output.queue.config;

import br.com.acmePay.constants.ConstantsKafka;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicsConfig {

    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(ConstantsKafka.TOPIC_TRANSFER_NAME)
                .partitions(1)
                .build();
    }

}
