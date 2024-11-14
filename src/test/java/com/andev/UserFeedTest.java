package com.andev;

import com.andev.entity.feed.FeedEntity;
import com.andev.entity.user.UserEntity;
import com.andev.repository.FeedRepository;
import com.andev.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class UserFeedTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneManyTest() {
        // 1. New user
        UserEntity user = new UserEntity();

        user.setUserName("bruno");
        user.setUserEmail("bruno@gmail.com");

        FeedEntity feed = new FeedEntity();
        feed.setTitle("feed 02");
        feed.setDescription("Description feed 0");

        user.setFeedList(List.of(feed));
        feed.setUser(user);

        userRepository.save(user);
        // feedRepository.save(feed);
        /**
         * cascade = CascadeType.ALL
         * Khi bạn lưu UserEntity với CascadeType.ALL, JPA sẽ tự động lưu các đối tượng FeedEntity liên kết.
         * */
    }

    @Test
    @Transactional
    void selectOneToManyTest() {
        UserEntity user = userRepository.findById(11L).orElseThrow();
        System.out.println(user);
        System.out.println(user.getFeedList());
    }
}
