package io.github.wotjd243.findbyhint.mission.infra;

import io.github.wotjd243.findbyhint.mission.domain.Mission;

import java.util.HashMap;
import java.util.Map;

public class DummyMissionData {
    private static final Map<Integer, Mission> data = new HashMap<>();

    static {
        put(1, "How many points did LeBron James score in his first NBA game?", "25", "1", 0  );
        put(2, "Sting, the lead vocalist of The Police, primarily plays what instrument?", "Bass Guitar", "1", 0  );
        put(3, "What is the capital of Indonesia?", "Jakarta", "1", 0  );
        put(4, "The music group Daft Punk got their name from a negative review they recieved.", "True", "1", 0  );
        put(5, "What Nationality is D.Va from Overwatch?", "Korean", "1", 0  );
        put(6, "Brian May was the guitarist for which band?", "Queen", "1", 0  );
        put(7, "One of Donald Trump's 2016 Presidential Campaign promises was to build a border wall between the United States and Mexico.", "True", "1", 0  );
        put(8, "What is the title of song on the main menu in Halo?", "Halo", "1", 0  );
        put(9, "When was the United States National Security Agency established?", "November 4, 1952", "2", 0  );
        put(10, "What is the capital of Slovakia?", "Bratislava", "2", 0  );
        put(11, "The book 'Fahrenheit 451' was written by whom?", "Ray Bradbury", "2", 0  );
        put(14, "On what day did Germany invade Poland?", "September 1, 1939", "3", 0  );
        put(15, "The Ceratosaurus, a dinosaur known for having a horn on the top of its nose, is also known to be a decendent of the Tyrannosaurus Rex.", "False", "3", 0  );
        put(16, "What mineral has the lowest number on the Mohs scale?", "Talc", "3", 0  );
        put(17, "In which Shakespearean play will you find the suicide of Ophelia?", "Hamlet", "3", 0  );
        put(18, "What year was Canada founded in?", "1867", "4", 0  );
        put(19, "What is the unit of electrical inductance?", "Henry", "4", 0  );
        put(20, "Before Super Smash Bros. contained Nintendo characters, what was it known as internally?", "Dragon King: The Fighting Game", "4", 0  );
    }

    public static Mission get(final int id) {
        return data.get(id);
    }

    private static Mission put(final int missionKey, final String question, final String answer, final String level, final int point) {
//        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
        return data.put(missionKey, new Mission(missionKey, question, answer, level, point));
    }
}
