package io.github.wotjd243.aladin.book.infra;

import io.github.wotjd243.aladin.book.domain.Book;

import java.util.HashMap;
import java.util.Map;

public class DummyBookData {
    private static final Map<Long, Book> data = new HashMap<>();

    static {
        put(1L, "이펙티브 자바", "조슈아 블로크", "IT서적", "개앞맵시");
        put(2L, "여행의 이유", "김영하", "에세이", "문학동네");
        put(3L, "설민석의 한국사 대모험 10", "설민석", "한국사", "아이휴먼");
        put(4L, "다녀올게:바닷마을 다이어리 9", "요시다 아키미", "만화", "애니북스");
        put(5L, "50대 사건으로 보는 돈의 역사", "홍춘욱", "경제경영", "로크미디어");
        put(6L, "공부머리 독서법", "최승필", "교육", "책구루");
        put(7L, "꽃을 보듯 너를 본다", "나태주", "한국시", "지혜");
        put(8L, "나는 나로 살기로 했다", "김수현", "에세이", "마음의 숲");
        put(9L, "사피엔스", "유발 하라리", "인문학", "김영사");
        put(10L, "돌이킬 수 없는 약속", "야쿠마루 가쿠", "소설", "북플라자");
        put(11L, "82년생 김지영", "조남주", "소설", "민음사");
        put(12L,"코스모스", "칼세이건", "과학", "사이언스북스");
        put(13L,"개인주의자 선언", "문유석", "인문학", "문학동네");
        put(14L,"나미야 잡화점의 기적", "히가시노 게이고", "소설", "현대문학");
        put(15L,"침묵의 봄", "레이첼 카슨", "과학", "에코리브르");
        put(16L,"데미안", "헤르만 헤세", "고전", "문학동네");
        put(17L,"융의 영혼의 지도", "머레이 스타인", "심리학", "문예출판사");
        put(18L,"영어회화 100일의 기적", "문성현", "외국어", "넥서스");
        put(19L,"봉제인형 살인사건", "다니엘 콜", "소설", "북플라자");
        put(20L,"내가 확실히 아는 것들", "오프라 윈프리", "에세이", "북하우스");
    }

    public static Book get(Long id) {
        return data.get(id);
    }

    private static Book put(Long id, String name, String author, String category, String publisher) {
        return data.put(id, new Book(name, author, category, publisher));
    }
}
