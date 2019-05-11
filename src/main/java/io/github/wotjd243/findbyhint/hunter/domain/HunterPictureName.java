package io.github.wotjd243.findbyhint.hunter.domain;

import io.github.wotjd243.findbyhint.util.check.Check;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class HunterPictureName {

    private String hunterPictureName;

    public HunterPictureName(String hunterPictureName) {
        validation(hunterPictureName);
        this.hunterPictureName = fileNameUnique(hunterPictureName);
    }

    private void validation(String hunterPictureName) {
        Check.imgCheck(hunterPictureName);
    }

    private String fileNameUnique(String hunterPictureName) {

        //파일 저장명 처리
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMDDHHmmss");
        String today = dateFormat.format(new Date());
        String modifyName = today + "_" + UUID.randomUUID().toString().substring(20) + "." + hunterPictureName;

        return modifyName;

    }


}
