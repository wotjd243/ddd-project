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
<<<<<<< HEAD
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
=======
}*/

public enum MissionLevel {
    EASY(1, "BRONZE"), MEDIUM(2, "SILVER"), HARD(3, "GOLD");

    private final int levelValue;
    private final String levelName;

    MissionLevel(int levelValue, String levelName) {
        this.levelValue = levelValue;
        this.levelName = levelName;
>>>>>>> d7cff6d... fix(mission): fix mission entity
    }

    public int getLevelValue() {
        return levelValue;
    }

    public String getLevelName() {
        return levelName;
    }

<<<<<<< HEAD
    public int getHintCounter() { return hintCounter;}
}
>>>>>>> afac6cd... *docs README 문서 수정
=======
}
>>>>>>> d7cff6d... fix(mission): fix mission entity
