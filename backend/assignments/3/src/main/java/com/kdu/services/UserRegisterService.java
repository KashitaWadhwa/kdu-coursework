package com.kdu.services;

import com.kdu.model.dto.request.UserRegisterRequestDTO;
import com.kdu.model.dto.response.UserResponseDTO;
import com.kdu.mapper.UserRegisterMapper;
import com.kdu.model.entity.UserModel;
import com.kdu.dao.UserRegisterRepository;
import com.kdu.model.utility.JwttokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRegisterService {

    private final UserRegisterRepository userRegisterRepository;
    private final UserRegisterMapper userRegisterMapper;
    private final JwttokenUtils jwttokenUtils;

    @Autowired
    public UserRegisterService(UserRegisterRepository userRegisterRepository,
                               UserRegisterMapper userRegisterMapper,
                               JwttokenUtils jwttokenUtils) {
        this.userRegisterRepository = userRegisterRepository;
        this.userRegisterMapper = userRegisterMapper;
        this.jwttokenUtils = jwttokenUtils;
    }

    public UserResponseDTO registerUser(UserRegisterRequestDTO userRegisterRequestDTO){
        UserModel userModel = userRegisterMapper.userMapping(userRegisterRequestDTO);
        userRegisterRepository.save(userModel);
        String token = jwttokenUtils.getTokenNew(userRegisterRequestDTO);
        return new UserResponseDTO("User added successfully",token);
    }

}
