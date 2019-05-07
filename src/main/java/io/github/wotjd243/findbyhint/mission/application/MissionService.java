package io.github.wotjd243.findbyhint.mission.application;

import io.github.wotjd243.findbyhint.mission.domain.Mission;
import io.github.wotjd243.findbyhint.mission.domain.MissionLevel;
import io.github.wotjd243.findbyhint.mission.domain.MissionRepository;
import io.github.wotjd243.findbyhint.mission.domain.SuccessMissionService;
import org.springframework.stereotype.Service;

@Service
public class MissionService {
    private MissionRepository missionRepository;

    public MissionService(final MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public int takePoint(final String level) {
        final Mission mission = getMission(level);
        final SuccessMissionService successMissionService = new SuccessMissionService(mission);
        return successMissionService.isSuccess();
    }

    private Mission getMission(final String level) {
        return missionRepository.findById(MissionLevel.valueOf(level))
                .orElseThrow(IllegalArgumentException::new);
    }

}
