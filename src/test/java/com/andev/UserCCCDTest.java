package com.andev;

import com.andev.entity.user.CCCDEntity;
import com.andev.entity.user.UserEntity;
import com.andev.repository.CCCDRepository;
import com.andev.repository.UserRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserCCCDTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CCCDRepository cccdRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToOneTest() {
        UserEntity user  = new UserEntity();
        CCCDEntity cccd  = new CCCDEntity();

        user.setUserName("Bernardo silva");
        user.setUserEmail("silva@gmail.com");

        cccd.setNumberCCCD("1111111111");

        user.setCccd(cccd);

        userRepository.save(user);
    }
}