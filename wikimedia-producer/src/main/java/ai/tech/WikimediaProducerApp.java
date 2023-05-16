package ai.tech;

import ai.tech.service.infrastructure.producer.WikimediaRecentChangesProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class WikimediaProducerApp implements CommandLineRunner {
    private final WikimediaRecentChangesProducer wikimediaRecentChangesProducer;

    public static void main(final String[] args) {
        SpringApplication.run(WikimediaProducerApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        wikimediaRecentChangesProducer.sendMessage();
    }
}
