package io.github.wotjd243.findbyhint.hint.domain;

import io.github.wotjd243.findbyhint.hunter.domain.HunterId;

// 힌트테이블과 헌터테이블을 연결한 게시판
public class HintInventory {
    // TODO (1) 멤버값이 영찬인 힌트인벤토리에서 힌트의 번호를(배열) 알려주기

    private Long inventoryNum;     /* autoIncrement PK 값*/
    private HunterId hunterId;     /* 다대일 설정  */
    private Hint hintNum;


    // SET 메서드로 구현해야될 변수들을 생성자에서 구현 ( SET 메서드는 의미를 파악하기 어려움 )
    private HintInventory(Long inventoryNum,  Long hintNum, String hunterId) {
                validate(inventoryNum);
                this.inventoryNum = inventoryNum;
                this.hintNum = Hint.valueOfHintNum(hintNum);
                this.hunterId = new HunterId(hunterId);
    }


    public static HintInventory getInventoryList (Long inventoryNum,  Long hintNum, String hunterId) {
        return new HintInventory(inventoryNum,hintNum,hunterId);
    }





            public void validate(final Long inventoryNum) {
                if (inventoryNum < 1 || inventoryNum > 101) {
                    // 자바 표준 익셉션
            throw new IllegalArgumentException();
        }
    }
}