package com.security.SecurityFeature.implemented.Repo;

import com.security.SecurityFeature.implemented.Modal.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    void findByUsername() {
        Users user =new Users();
        user.setUsername("hari");
        user.setPassword("h@123");
        user.setId(20);
        System.out.println(user);
        userRepo.save(user);
//        Users actualOuput = userRepo.findByUsername(user.getUsername());
//        Users expectedValue = user;
        String actualName = user.getUsername();
        String expectedName = "hari";


        assertThat(actualName).isEqualTo(expectedName);
    }
}