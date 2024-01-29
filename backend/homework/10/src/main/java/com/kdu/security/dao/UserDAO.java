package com.kdu.security.dao;


import com.kdu.security.exception.custom.UserNotFoundException;
import com.kdu.security.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO {

    private final List<User> userList;

    public UserDAO() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        throw new UserNotFoundException(username);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userList);
    }

    public void updateUser(User updatedUser) {
        int index = getUserIndexByUsername(updatedUser.getUserName());
        if (index != -1) {
            userList.set(index, updatedUser);
        }
    }

    public void deleteUserByUsername(String username) {
        int index = getUserIndexByUsername(username);
        if (index != -1) {
            userList.remove(index);
        }
    }

    private int getUserIndexByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(username)) {
                return i;
            }
        }
        return -1;
    }
}
