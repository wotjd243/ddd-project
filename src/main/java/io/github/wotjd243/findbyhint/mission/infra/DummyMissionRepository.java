package io.github.wotjd243.findbyhint.mission.infra;

import io.github.wotjd243.findbyhint.mission.domain.Mission;
import io.github.wotjd243.findbyhint.mission.domain.MissionLevel;
import io.github.wotjd243.findbyhint.mission.domain.MissionRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummyMissionRepository implements MissionRepository {
    @Override
    public Optional<Mission> findById(final MissionLevel level) {
        return Optional.ofNullable(DummyMissionData.get(level.getLevelValue()));
    }
}
