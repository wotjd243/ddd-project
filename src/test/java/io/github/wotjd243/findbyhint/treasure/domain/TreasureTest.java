package io.github.wotjd243.findbyhint.treasure.domain;

import io.github.wotjd243.findbyhint.util.check.DateObject;
import org.junit.Test;

import java.time.LocalDate;

public class TreasureTest {

    @Test
    public void 보물생성(){
        // given
        DateObject dateObject = new DateObject();
        final LocalDate startDate = dateObject.getDate().plusDays(10L);
        final LocalDate endDate = dateObject.getDate().plusDays(11L);
        final String latitude = "126.9941658";
        final String hardness = "37.4954676";


        // when
        //Treasure result =  Treasure.valueOf(1L,"김도영","qrCode","상태",latitude,hardness,startDate,endDate);

        // then
        }   
    }

