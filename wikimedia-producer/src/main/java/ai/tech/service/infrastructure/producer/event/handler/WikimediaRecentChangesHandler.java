package ai.tech.service.infrastructure.producer.event.handler;

import ai.tech.service.infrastructure.util.KafkaConstants;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

// To read teal time stream data from Wikimedia, we use event sourcing
@Slf4j
@RequiredArgsConstructor
public class WikimediaRecentChangesHandler implements EventHandler {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    @Override
    public void onOpen() throws Exception {}

    @Override
    public void onClosed() throws Exception {}

    @Override
    public void onMessage(final String s, final MessageEvent messageEvent) throws Exception {
        kafkaTemplate.send(topic, messageEvent.getData());
        log.info("Sent event data: {}, to topic: {}", messageEvent.getData(), KafkaConstants.TOPIC_NAME);
    }

    @Override
    public void onComment(String s) throws Exception {}

    @Override
    public void onError(Throwable throwable) {}
}
