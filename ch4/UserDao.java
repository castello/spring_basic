package com.fastcampus.ch3;

public interface UserDao {
    int deleteUser(String id);

    User selectUser(String id);

    // 사용자 정보를 user_info테이블에 저장하는 메서드
    int insertUser(User user);

    // 매개변수로 받은 사용자 정보로 user_info테이블을 update하는 메서드
    int updateUser(User user);

    void deleteAll() throws Exception;
}
