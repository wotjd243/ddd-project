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
<<<<<<< HEAD
}
=======
}*/

public enum MissionLevel {
    EASY(1, "BRONZE",2), MEDIUM(2, "SILVER",4), HARD(3, "GOLD",8);

    private final int levelValue;
    private final String levelName;
    private final int hintCounter ;


    MissionLevel(int levelValue, String levelName, int hintCounter) {
        this.levelValue = levelValue;
        this.levelName = levelName;
        this.hintCounter = hintCounter;
    }

    public int getLevelValue() {
        return levelValue;
    }

    public String getLevelName() {
        return levelName;
    }

    public int getHintCounter() { return hintCounter;}
}
>>>>>>> afac6cd... *docs README 문서 수정
