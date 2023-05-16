package ai.tech.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class WikimediaRecentChange {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Lob private String wikimediaRecentChangeData;
}
