package ai.tech.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class WikimediaRecentChange {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID id;
    @Lob private String data;
}
