package com.shivam.sequencegenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shivam.sequencegenerator.bean.User;
import com.shivam.sequencegenerator.daos.SequenceRepository;
import com.shivam.sequencegenerator.daos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author sksingh created on 27/12/23
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class InsertUserData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final SequenceRepository sequenceRepository;

    @Override
    public void run(String... args) throws Exception {


        userRepository.deleteAll();
        sequenceRepository.deleteAll();

        User user1 = new User();
        user1.setEmail("john@gmail.com");
        userRepository.insert(user1);


        User user2 = new User();
        user2.setEmail("jacob@gmail.com");
        userRepository.insert(user2);

        // Testing if inserting the same primary key will throw an exception or not.
        try {
            User user3 = new User();
            user3.setUserId(1L);
            user3.setEmail("julie@gmail.com");
            userRepository.insert(user3);
        } catch (Exception e) {
            log.error("Error occurred", e);
        }

        for (User user : userRepository.findAll()) {
            log.info("User: {}", new ObjectMapper().writeValueAsString(user));
        }
    }
}
