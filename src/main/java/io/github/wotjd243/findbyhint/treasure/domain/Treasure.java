package io.github.wotjd243.findbyhint.treasure.domain;

import java.time.LocalDate;

public class Treasure {
    // TODO (1) 보물이 생성될때 러닝타임의 시작일 과 종료일은
    // TODO (2) 1에서 151 사이의 값을 갖도록 유효성 검사

    //보물의 이름
    private final String name;

    //보물로 접근할 수 있는 QR코드
    private final String qrCode;

    // 러닝타임 시작일
    private final LocalDate startDate;

    // 러닝타임 종료일
    private final LocalDate endDate;

    public Treasure(String name, String qrCode, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.qrCode = qrCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
