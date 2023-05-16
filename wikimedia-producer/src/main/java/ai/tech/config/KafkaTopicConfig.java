package ai.tech.config;

import ai.tech.service.infrastructure.util.KafkaConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic createWikimediaTopic() {
        return TopicBuilder.name(KafkaConstants.TOPIC_NAME).build();
    }
}
