package io.github.book.collected.domain;

import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
public class BookLocation {
    private String storeLocation;
    private String bookshelfLocation;

    @Builder
    public BookLocation(String storeLocation, String bookshelfLocation) {
        amendStoreLocation(storeLocation);
        amendBookshelfLocation(bookshelfLocation);
    }

    public void amendStoreLocation(String storeLocation) {
        if(StringUtils.isEmpty(storeLocation)) {
            throw new IllegalArgumentException("가게 정보는 필수 정보입니다.");
        }
        this.storeLocation = storeLocation;
    }

    public void amendBookshelfLocation(String bookshelfLocation) {
        if(StringUtils.isEmpty(bookshelfLocation)) {
            throw new IllegalArgumentException("책장 위치 정보는 필수 정보입니다.");
        }
        this.bookshelfLocation = bookshelfLocation;
    }
}
