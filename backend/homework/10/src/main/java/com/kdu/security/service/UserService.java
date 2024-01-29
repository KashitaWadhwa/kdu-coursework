package com.kdu.security.service;

import com.kdu.security.dao.UserDAO;
import com.kdu.security.dto.AuthDTO;
import com.kdu.security.dto.UserDTO;
import com.kdu.security.exception.custom.UserNotFoundException;
import com.kdu.security.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserDAO userDAO, BCryptPasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userDAO.getAllUsers();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserByUsername(String username) {
        User user = userDAO.getUserByUsername(username);

        if (user != null) {
            return convertToDTO(user);
        } else {
            // Throw custom UserNotFoundException when user is not found
            throw new UserNotFoundException(username);
        }
    }
    public void addUser(AuthDTO authDTO) {
        User newUser = convertToEntity(authDTO);
        userDAO.addUser(newUser);
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO("yourUsername", "yourPassword", "yourEmail");
        userDTO.setUsername(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        // Add any other fields relevant to security
        return userDTO;
    }

    private User convertToEntity(AuthDTO authDTO) {
        User user = new User("yourUsername", "yourPassword", "yourEmail");

        user.setUserName(authDTO.getUsername());
        user.setPassword(passwordEncoder.encode(authDTO.getPassword()));
        // You may set other fields as needed
        return user;
    }
}
