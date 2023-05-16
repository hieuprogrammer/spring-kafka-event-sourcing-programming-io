package ai.tech.service.infrastructure.producer;

import ai.tech.service.infrastructure.producer.event.handler.WikimediaRecentChangesHandler;
import ai.tech.service.infrastructure.util.KafkaConstants;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class WikimediaRecentChangesProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        final EventHandler eventHandler = new WikimediaRecentChangesHandler(kafkaTemplate, KafkaConstants.TOPIC_NAME);
        final String uri = "https://stream.wikimedia.org/v2/stream/recentchange";
        final EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(uri));
        final EventSource eventSource = builder.build();
        eventSource.start();                                                   

        TimeUnit.MINUTES.sleep(10); // Stop in 10 minutes.
    }
}
