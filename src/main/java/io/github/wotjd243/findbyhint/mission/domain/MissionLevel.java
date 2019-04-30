package io.github.wotjd243.findbyhint.mission.domain;

public class MissionLevel {

    private String level;

    public MissionLevel(final String level) {
        validation(level);
        this.level = level;
    }

    private void validation(String level) {
        if(!(level.equals("브론즈") || level.equals("실버") || level.equals("골드") || level.equals("플래티넘"))) {
            throw new IllegalArgumentException();
        }
    }
}
