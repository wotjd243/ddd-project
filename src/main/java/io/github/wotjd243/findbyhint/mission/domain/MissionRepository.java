package io.github.wotjd243.findbyhint.mission.domain;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MissionRepository {
    Optional<Mission> findById(final MissionLevel level);

//    Optional<Mission> findByLevel(final String level);
}
