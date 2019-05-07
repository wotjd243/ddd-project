package io.github.wotjd243.findbyhint.util.check;


import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

//@Service
public class Check {

    public static void idpwCheck(String value) {

        char chrInput;
        int length = value.length();

        for (int i = 0; i < length; i++) {

            chrInput = value.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크

            if (chrInput >= 0x61 && chrInput <= 0x7A) {
                // 영문(소문자) OK!
            } else if (chrInput >= 0x41 && chrInput <= 0x5A) {
                // 영문(대문자) OK!
            } else if (chrInput >= 0x30 && chrInput <= 0x39) {
                // 숫자 OK!
            } else {
                log.println("영소문자,대문자,숫자만 사용해서 아이디를 만들어야합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void lengthLimit(String value, int limit) {
        // 길이수 제한
        int length = value.length();

        if (length > limit) {
            log.println("길이수가 " + limit + "자를 초과합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void startEngCheck(String value) {
        // 시작 글자 영문 소문자
        String hunterId1 = value.substring(0, 1);
        if (!Pattern.matches("[a-z]", hunterId1)) {
            log.println("첫글자가 영어가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void numberLimit(int value, int limit) {

        if (value > limit) {
            log.println(value + " 값이 " + limit + "을 초과하였습니다.");
            throw new IllegalArgumentException();
        }

    }

    public static void imgCheck(String value) {

        String originalNameExtension = value.substring(value.lastIndexOf(".") + 1).toLowerCase();

        // 확장자 제한
        if (!((originalNameExtension.equals("jpg")) || (originalNameExtension.equals("gif"))
                || (originalNameExtension.equals("png")) || (originalNameExtension.equals("bmp")))) {

            log.println("이미지 확장자가 아닙니다.");

            throw new IllegalArgumentException();
        }
    }

    public static void fileCheck(String value) {

        String originalNameExtension = value.substring(value.lastIndexOf(".") + 1).toLowerCase();

        // 확장자 제한
        if (((originalNameExtension.equals("html")) || (originalNameExtension.equals("php")) || (originalNameExtension.equals("exe")) || (originalNameExtension.equals("js")) || (originalNameExtension.equals("java")) || (originalNameExtension.equals("class")))) {
            log.println("업로드가 불가한 파일확장자 입니다.");
            throw new IllegalArgumentException();
        }
    }

}
