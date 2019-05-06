package io.github.wotjd243.findbyhint.hint.domain;

import org.junit.Test;
public class HintTest {



    @Test
    public void 힌트생성(){

        final String level = "브론즈";
        final String latitude = "126.9941658";
        final String hardness = "37.4954676";

        Hint result = Hint.valueOf(1, level,latitude,hardness);
    }






}