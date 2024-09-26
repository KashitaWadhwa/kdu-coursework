package com.kdu.jpa.service;

import com.kdu.jpa.dao.UserRepository;
import com.kdu.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }
    public void saveUser(User user){
        userRepository.save(user);
    }


    public Page<User> findAllUsersPaginated(int pageNumber, int pageSize) {
        pageNumber = Math.max(0, pageNumber);
        pageSize = Math.min(50, Math.max(1, pageSize));

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageRequest);
    }

}
