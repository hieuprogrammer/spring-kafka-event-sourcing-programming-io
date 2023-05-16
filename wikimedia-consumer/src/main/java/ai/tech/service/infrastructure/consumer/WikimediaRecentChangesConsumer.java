package ai.tech.service.infrastructure.consumer;

import ai.tech.domain.WikimediaRecentChange;
import ai.tech.repository.WikimediaRecentChangeRepository;
import ai.tech.service.infrastructure.util.KafkaConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class WikimediaRecentChangesConsumer {
    private final WikimediaRecentChangeRepository wikimediaRecentChangeRepository;

    @KafkaListener(topics = KafkaConstants.TOPIC_NAME, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(final String message) {
        log.info("Received event data: {}, from topic: {}", message, KafkaConstants.TOPIC_NAME);
        wikimediaRecentChangeRepository.save(WikimediaRecentChange.builder()
                .wikimediaRecentChangeData(message).build());
    }
}
