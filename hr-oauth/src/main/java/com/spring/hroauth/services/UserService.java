package com.spring.hroauth.services;

import com.spring.hroauth.entities.User;
import com.spring.hroauth.feignclients.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEMail(email).getBody();
        if (user == null) {
            log.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }

        log.info("Email found: " + email);

        return user;
    }
}
