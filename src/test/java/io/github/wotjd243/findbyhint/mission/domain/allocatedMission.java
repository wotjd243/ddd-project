package io.github.wotjd243.findbyhint.mission.domain;

public class allocatedMission {
    public static void main(String[] args) {
        int count = 12;
        for(int i = 4; i > 0; i--) {
            for(int i2 =0; i2 <= i; i2++){

                switch (i2) {
                    case 0:
                        System.out.println("브론즈 미션 생성");
                        break;
                    case 1:
                        System.out.println("실버 미션 생성");
                        break;
                    case 2:
                        System.out.println("골드 미션 생성");
                        break;
                    case 3:
                        System.out.println("플래티넘 미션 생성");
                        break;
                }
                count--;

                if(count < 0){
                    break;
                }
            }
            if(count < 0){
                break;
            }
        }


    }
}
