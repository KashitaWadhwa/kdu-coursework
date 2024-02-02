package com.kdu.myapplication.service;

import com.kdu.myapplication.dao.UserRepository;
import com.kdu.myapplication.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil; // Assume you have a JWT utility class

    public void saveUser(User user) {
        userRepository.save(user);
    }
//    public String generateToken(User user) {
//        // You can customize this method based on your authentication logic
//        // Here, assuming a simple example using a JWT utility class
//        return jwtTokenUtil.generateToken(user);
//    }
//
//
//    public UserDTO addUser(UserDTO userDTO) {
//        User user = userMapper.mapUserDTO(userDTO);
//        saveUser(user);
//
//        // Generate and set JWT token
//        String jwtToken = generateToken(user);
//        userDTO.setJwtToken(jwtToken);
//
//        return userDTO;
//    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
}
