package io.github.wotjd243.findbyhint.hint.domain;

public class Hint {
    // TODO (1) 힌트는 지도상에 범위로 표현된다.
    // TODO (2) 힌트를 풀면 해당힌트가 가지고 있는 반지름을 토대로  원의 면적을 보여준다.
    private final Long hintNum;
    private double radius;

    private Hint(final Long hintNum) {
        validate(hintNum);
        this.hintNum = hintNum;
    }

    // 헌트테이블의 PK값을 전해주는 정적 팩토리 메서드 만들기
    public static Hint valueOfHintNum (final Long hintNum){
        return new Hint(hintNum);
    }

    public void validate(final Long hintNum){
        if(hintNum < 1 || hintNum > 151){
            // 자바 표준 익셉션
            throw new IllegalArgumentException();
        }
    }

}

    // 로직설계하기
    // Trasure 클래스 TargetPoint 메서드 로 좌표값을 구해서 거기서 부터 원의 면적값과 반지름값을 구현한다.
