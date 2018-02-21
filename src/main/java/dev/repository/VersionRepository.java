package dev.repository;

import dev.domain.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version, Integer> {
}
