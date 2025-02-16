package com.dyatmarize.restauth.service;

import com.dyatmarize.restauth.api.request.LoginRequest;
import com.dyatmarize.restauth.api.request.RegisterRequest;
import com.dyatmarize.restauth.api.response.BaseResponse;
import com.dyatmarize.restauth.entity.Users;
import com.dyatmarize.restauth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public BaseResponse register(RegisterRequest request) {
        log.info("==================== REGISTER USER ====================");
        final boolean isUserExists = userRepository.findByEmail(request.getEmail()).isPresent();
        if (isUserExists) {
            return BaseResponse.builder()
                    .withSuccess(false)
                    .withData("Register Failed, User Already Exists")
                    .build();
        } else {
            Users user = new Users();
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
            user.setCreatedAt(Instant.now());
            user.setUpdatedAt(Instant.now());
            final var createdUser = userRepository.save(user);
            return BaseResponse.builder()
                    .withSuccess(true)
                    .withData("Register success, with user : " + createdUser)
                    .build();
        }
    }

    public BaseResponse doLogin(LoginRequest request) {
        log.info("==================== LOGGING IN ====================");
        final var user = userRepository.findByEmail(request.getEmail());
        if (user.isPresent()) {
            log.info("Check Password Validity");
            if (passwordEncoder.matches(request.getPassword(), user.get().getPasswordHash())) {
                return BaseResponse.builder()
                        .withSuccess(true)
                        .withData("Welcome " + user.get().getName())
                        .build();
            } else {
                return BaseResponse.builder()
                        .withSuccess(false)
                        .withData("Wrong Password!")
                        .build();
            }
        } else {
            return BaseResponse.builder()
                    .withSuccess(false)
                    .withData("User With " + request.getEmail() + "Not Found.")
                    .build();
        }
    }
}
