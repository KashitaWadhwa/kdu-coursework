package com.kdu.jdbc.service;

import com.kdu.jdbc.dao.UsersDAO;
import com.kdu.jdbc.entity.UsersEntity;
import com.kdu.jdbc.exception.DataNotFoundException;
import com.kdu.jdbc.exception.OperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UsersService {

    private final UsersDAO usersDAO;

    @Autowired
    public UsersService(UsersDAO usersDAO){
        this.usersDAO=usersDAO;
    }

    public void addUser(UsersEntity user){
        try{
            usersDAO.addUser(user);
        }
        catch(Exception e){
            throw new OperationException("Unable to add User");
        }
    }

    public List<UsersEntity> getAllUsers(UUID tenantId){
        List<UsersEntity> usersEntityList;
        try{
            usersEntityList=usersDAO.getAllUsers(tenantId);
        }catch (Exception e)
        {
            throw new DataNotFoundException("Unable to find users for tenantId");
        }
        return usersEntityList;
    }

    public void updateUser(UUID userId, UsersEntity user){
        try{
            usersDAO.updateUser(userId,user);
        }catch (Exception e){
            throw new DataNotFoundException("Unable to find user with UserId");
        }
    }
}
