package io.github.wotjd243.shoppinggogo.user.infra;

import io.github.wotjd243.shoppinggogo.user.domain.*;
import sun.security.util.Password;

import java.util.HashMap;
import java.util.Map;

public class DummyUserData {
    private static final Map<Long,User> users = new HashMap<Long, User>();

    /*
    private Long id;
    private Email email;
    private Address address;
    private Phone phoneNumber;
    private PassWord password;
     */

    static {
        put(1L,"ddd01@daum.net", "서울시","01011112222","password01");
        put(2L,"ddd02@daum.net", "서울시","01022223333","password02");
        put(3L,"ddd03@daum.net", "서울시","01033334444","password03");
        put(4L,"ddd04@daum.net", "서울시","01044445555","password04");
        put(5L,"ddd05@daum.net", "서울시","01055556666","password05");
        put(6L,"ddd06@daum.net", "서울시","01066667777","password06");
        put(7L,"ddd07@daum.net", "서울시","01077778888","password07");

    }

    public static User get(final Long id){
        return users.get(id);
    }

    private static User put(final Long id,final String email, final String address, final String phoneNumber, final String password){

        return users.put( id, new User( id,new Email(email), new Address(address),new Phone(phoneNumber), new PassWord(password) ));
    }
}
