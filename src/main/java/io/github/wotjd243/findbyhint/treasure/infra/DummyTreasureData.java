package io.github.wotjd243.findbyhint.treasure.infra;

import io.github.wotjd243.findbyhint.mission.domain.Mission;
import io.github.wotjd243.findbyhint.treasure.domain.DateObject;
import io.github.wotjd243.findbyhint.treasure.domain.QRCodeVO;
import io.github.wotjd243.findbyhint.treasure.domain.TargetPoint;
import io.github.wotjd243.findbyhint.treasure.domain.Treasure;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class DummyTreasureData {

    private static final Map<Long, Treasure> data = new HashMap<>();

    static {
        
        QRCodeVO qrCodeVO= new QRCodeVO("https://blog.naver.com/doyoung0205",300,300,"0xff000000","0xffffffff","비밀번호");
        final Long treasureId = 1L;
        final String treasureName = "보물이름";
        final String runningStatus = "대기";
        List<TargetPoint> targetPointList = new ArrayList<>();
        Double latitude = 37.4954388;
        Double hardness = 127.0292711;

        TargetPoint realTargetPoint = TargetPoint.valueOfIatitudeAndHardness(latitude,hardness,"1");

        IntStream.range(1,10).forEach(i ->{
            targetPointList.add(realTargetPoint.getFakeTargetPoint());
        });

        targetPointList.add(realTargetPoint);

        final LocalDate startDate = LocalDate.now();
        final LocalDate endDate = LocalDate.of(2020,12,12);
        final List<Mission> missionList = new ArrayList<>();

        missionList.add(new Mission(1, "How many points did LeBron James score in his first NBA game?", "25", "1", 0  ));
        missionList.add(new Mission(2, "Sting, the lead vocalist of The Police, primarily plays what instrument?", "Bass Guitar", "1", 0  ));
        missionList.add(new Mission(3, "What is the capital of Indonesia?", "Jakarta", "1", 0  ));
        missionList.add(new Mission(4, "The music group Daft Punk got their name from a negative review they recieved.", "True", "1", 0  ));
        missionList.add(new Mission(5, "What Nationality is D.Va from Overwatch?", "Korean", "1", 0  ));
        missionList.add(new Mission(6, "Brian May was the guitarist for which band?", "Queen", "1", 0  ));
        missionList.add(new Mission(7, "One of Donald Trump's 2016 Presidential Campaign promises was to build a border wall between the United States and Mexico.", "True", "1", 0  ));
        missionList.add(new Mission(8, "What is the title of song on the main menu in Halo?", "Halo", "1", 0  ));
        missionList.add(new Mission(9, "When was the United States National Security Agency established?", "November 4, 1952", "2", 0  ));
        missionList.add(new Mission(10, "What is the capital of Slovakia?", "Bratislava", "2", 0  ));
        missionList.add(new Mission(11, "The book 'Fahrenheit 451' was written by whom?", "Ray Bradbury", "2", 0  ));
        missionList.add(new Mission(14, "On what day did Germany invade Poland?", "September 1, 1939", "3", 0  ));
        missionList.add(new Mission(15, "The Ceratosaurus, a dinosaur known for having a horn on the top of its nose, is also known to be a decendent of the Tyrannosaurus Rex.", "False", "3", 0  ));


        put(treasureId, treasureName,
                runningStatus, qrCodeVO,
                targetPointList,
                startDate, endDate,
                missionList);
    }

    public static Treasure get(final Long key) {
        return data.get(key);
    }

    private static Treasure put(Long treasureId, String treasureName,
                                String runningStatus, QRCodeVO qrCodeVO,
                                List<TargetPoint> targetPointList,
                                final LocalDate startDate, final LocalDate endDate,
                                final List<Mission> missionList) {

        return data.put(treasureId,new Treasure(treasureName,runningStatus,qrCodeVO,targetPointList,startDate,endDate,missionList));

    }
}
