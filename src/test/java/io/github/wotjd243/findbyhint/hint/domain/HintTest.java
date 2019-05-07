package io.github.wotjd243.findbyhint.hint.domain;
import org.junit.Test;
public class HintTest {
    @Test
    public void 힌트인벤토리생성(){
        // given


        String hunterId = "youngchan";
        Long hintNum = 4L;
        final Long inventoryNum = 3L;

        // when
        HintInventory hintInventory =  HintInventory.getInventoryList(inventoryNum,hintNum,hunterId);
        // then
    }


    @Test
    public void 힌트생성(){
        // given
        final Long number = 4L;
        // when
        Hint hintNum = Hint.valueOfHintNum(number);
        // then
    }




}