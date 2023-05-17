package ai.tech.repository;

import ai.tech.domain.WikimediaRecentChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WikimediaRecentChangeRepository extends JpaRepository<WikimediaRecentChange, UUID> {}
