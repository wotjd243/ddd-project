package io.github.book.domain.book.infra;

import io.github.book.domain.book.domain.Author;
import io.github.book.domain.book.domain.Book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DummyBookData {
    private static final Map<String, Book> data = new HashMap<>();

    static {
        put("978-89-97924-41-7", "성공하는 프로그래밍 공부법", "박재성", 39, "코드스쿼드에서 같이한 정휘준 친구 이야기가 나온다.", LocalDate.now());
        put("978-89-97924-24-0", "자바 웹 프로그래밍 Next Step", "박재성", 39, "양파 껍질을 까보자.", LocalDate.now());
        put("978-89-97924-41-7", "이펙티브 자바 3판", "조슈아 블로크", 44, "2판도 다 안봤는데 3판이 나와버렸다.", LocalDate.now());
        put("979-11-6050-681-5", "스프링 마이크로 서비스 코딩 공작소", "존 카넬", 39, "양파 껍질을 까보자", LocalDate.now());
        put("978-89-6626-404-9", "리눅스 커널 이야기", "강진우", 37, "책 볼땐 알것 같은데 책 펴놓고 실제 활용하려 해도 머리가 백지가 된다.", LocalDate.now());
        put("978-89-6629-092-8", "자바 성능 튜닝 이야기", "이상민", 39, "성능이 문제가 아니라 그냥 내 코드가 노답", LocalDate.now());
        put("978-89-9813-976-6", "객체지향의 사실과 오해", "조영호", 39, "올 하반기에 다음시리즈 나온다던데 기대 중", LocalDate.now());
        put("978-89-6055-283-7", "TCP/IP 프로토콜", "Begrouz A. Forouzan", 39, "다 까먹음", LocalDate.now());
        put("89-329-0469-3", "세상의 바보들에게 웃으면서 화내는 방법", "움베르토 에코", 74, "더이상 에코의 신작이 나올수 없다니....", LocalDate.now());
        put("978-11-334-7996-2", "요츠바랑 14권", "아즈마 키요히코", 39, "모델로 삼았던 옆집 꼬맹이 다 컸다던데....", LocalDate.now());
        put("978-89-546-3726-8", "십이국기: 히쇼의 새", "오누 후유미", 39, "10년 넘게 신간을 안내고 있다.", LocalDate.now());
        put("978-89-6077-103-1", "토비의 스프링", "이일민", 39, "이거 두권이랑 JPA 책 침대 옆에 두고 탁자로 쓰고 있다.", LocalDate.now());
    }

    public static Book get(String isbn) {
        return data.get(isbn);
    }

    public static Optional<Book> findByTitle(String title) {
        return data.values().stream().filter(book -> book.isContainsTitle(title)).findFirst();
    }

    private static Book put(String isbn, String title, String authorName, int age, String description, LocalDate publishedDate) {
        Author author = new Author(authorName, age);
        return data.put(isbn, new Book(isbn, title, author, description, publishedDate));
    }

}
