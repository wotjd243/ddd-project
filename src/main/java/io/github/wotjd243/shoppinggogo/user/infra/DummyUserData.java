package io.github.wotjd243.shoppinggogo.user.infra;

import io.github.wotjd243.shoppinggogo.user.domain.*;
import sun.security.util.Password;

import java.util.HashMap;
import java.util.Map;

public class DummyUserData {
    private static final Map<Long,User> users = new HashMap<Long , User>();

    /*
    private Long id;
    private Email email;
    private Address address;
    private Phone phoneNumber;
    private PassWord password;
     */

    static {
        put(1l,"ddd01@daum.net", "서울시","01011112222");
        put(2l,"ddd02@daum.net", "서울시","01022223333");
        put(3l,"ddd03@daum.net", "서울시","01033334444");
        put(4l,"ddd04@daum.net", "서울시","01044445555");
        put(5l,"ddd05@daum.net", "서울시","01055556666");
        put(6l,"ddd06@daum.net", "서울시","01066667777");
        put(7l,"ddd07@daum.net", "서울시","01077778888");
    }

    public static User get(final Long id){
        return users.get(id);
    }

    private static User put(final Long id,final String email, final String address, final String phoneNumber){

        return users.put( id, new User( id, email, address, phoneNumber ));
    }
}
