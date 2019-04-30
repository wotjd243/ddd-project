# DDD-project Book

## 프로젝트 주제

도서 대여 시스템.

## 요구사항 정리

- 책
    - [x]  책은 고유한 국제 표준 도서 번호(International Standard Book Number, ISBN)를 가진다.
    - [x]  책은 제목과 설명, 저자, 출판일에 대한 정보를 가지고 있다.
    - [x]  책은 현재 대여 여부에 대한 정보를 가지고 있다.
    - [x]  이미 대여된 책은 다른 사용자에 의해서 대여될 수 없다.
- 대여 기록
    - [x]  대여 기록에는 대여된 날짜, 반납된 날짜, 대여된 책의 정보와 대여한 사람의 정보를 가진다.
    - [x]  대여 기록에는 반납기한 정보를 가진다.
    - [ ]  대여 예약을 한 사용자 정보를 가진다.(옵션)
- 사용자
    - [x]  사용자는 생년월일, 이름, 전화번호에 대한 정보를 가지고 있다.
    - [x]  사용자는 책을 대여할 수 있다.
    - [x]  사용자는 30일 이상 반납되지 않은 책이 있을 경우 대여를 할 수 없다.
    - [x]  사용자는 5권 이상의 책을 대여하고 있는 경우 대여를 할 수 없다.
    - [ ]  다섯 번 이상의 연체 기록이 있는 경우 대여가 불가능하다.(옵션)

### **용어 사전**

[용어 사전](https://www.notion.so/tram/673867edbdd84a3282b2a9cafda08b58?v=ff0b0277bc14451f8c250ed63477e589)


### **모델링**

- `Book`은 고유한 ID를 가진다.
- `Book`은 제목, Isbn, 저자, 설명, 출팔일을 가진다.
- `Book`은 대여 중인지에 대한 상태값을 가진다.(isRent, true : 대여중, false : 미 대여중)
- `User`는 고유한 ID를 가진다.
- `User`는 이름, 전화번호, 생년월일을 가진다.
- `BookRentHistory`는 고유한 ID를 가진다.
- `BookRentHistory`는 대열 시작일, 반납일, 반납 예정일을 가진다.

## 도메인 계층 구현하기


    @Entity
    public class Book {
    	@Id
    	@GeneratedValue
    	private Long id;
    
    	private String title;
    	private String Isbn;
    	private String author;
    	private String description;
    	private LocalDate publishedDate;
    	private boolean isRent;
    }

    @Entity
    public class User {
    	@Id
    	@GeneratedValue
    	private Long id;
    	private String name;
    	private String phoneNumber;
    	private LocalDate birthDay;
    }

    @Entity
    public class BookRentHistory {
    	@Id
    	@GeneratedValue
    	private Long id;
    
    	private LocalDateTime rentStartDatetime;
    	private LocalDateTime returnDatetime;
    	private LocalDateTime returnDeadLine;
    }
