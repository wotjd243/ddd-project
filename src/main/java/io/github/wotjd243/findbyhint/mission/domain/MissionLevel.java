package io.github.wotjd243.findbyhint.mission.domain;

/*
public class MissionLevel {

    private String level;

    public MissionLevel(final String level) {
        validation(level);
        this.level = level;
    }

    private void validation(String level) {
        if(!(level.equals("1") || level.equals("2") || level.equals("3") || level.equals("4"))) {
            throw new IllegalArgumentException();
        }
    }
}*/

public enum MissionLevel {
    EASY(1, "BRONZE"), MEDIUM(2, "SILVER"), HARD(3, "GOLD");

    private final int levelValue;
    private final String levelName;

    MissionLevel(int levelValue, String levelName) {
        this.levelValue = levelValue;
        this.levelName = levelName;
    }

    public int getLevelValue() {
        return levelValue;
    }

    public String getLevelName() {
        return levelName;
    }

}