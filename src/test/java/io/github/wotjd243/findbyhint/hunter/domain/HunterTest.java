package io.github.wotjd243.findbyhint.hunter.domain;

import org.junit.Test;


public class HunterTest {
    @Test
    public void hunterCreate() {
        new Hunter("kjc3590","2222","김종찬","/file/file.png","file.png",200, hunterBullet);
    }
}