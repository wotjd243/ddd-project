package io.github.wotjd243.findbyhint.mission.domain;

import java.util.Optional;

public interface MissionRepository {
    Optional<Mission> findById(final MissionLevel level);

//    Optional<Mission> findByLevel(final String level);
}
