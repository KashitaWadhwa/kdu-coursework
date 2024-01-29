package com.kdu.security.service;

import com.kdu.security.dao.UserDAO;
import com.kdu.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDataInitializationService {

    private final UserDAO userDAO;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserDataInitializationService(UserDAO userDAO, BCryptPasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initializeUserData() {
        // Add default users during application startup
        List<User> defaultUsers = getDefaultUsers();
        defaultUsers.forEach(userDAO::addUser);
    }

    private List<User> getDefaultUsers() {
        User user1 = new User("rohit", passwordEncoder.encode("Testing123"), "rohit@example.com", "ROLE_ADMIN");
        User user2 = new User("ajay", passwordEncoder.encode("Testing123"), "ajay@example.com", "ROLE_USER");
        // Add more default users as needed

        return Arrays.asList(user1, user2);
    }
}
