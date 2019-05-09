package io.github.wotjd243.aladin.user.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserType {

    SELLER("판매자"),
    BUYER("구매자");

    final String text;

    public String getText() {
        return text;
    }
}
