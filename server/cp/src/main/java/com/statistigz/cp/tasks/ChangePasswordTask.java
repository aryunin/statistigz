package com.statistigz.cp.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChangePasswordTask {
    private final UserDetailsManager userDetailsManager;

    @Value("${constants.ChangePasswordTask.username}")
    private String username;

    @Scheduled(fixedDelayString = "${constants.ChangePasswordTask.delay}", timeUnit = TimeUnit.MINUTES)
    public void changePassword() {
        userDetailsManager.deleteUser(username);

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(username);
        UserDetails user = User.withUsername(username)
                .password("{noop}" + password)
                .build();
        log.info("~~~~~ USER: {}, PASSWORD: {} ~~~~~", username, password);

        userDetailsManager.createUser(user);
    }
}
