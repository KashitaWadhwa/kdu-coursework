package com.kdu.config;

import com.kdu.dao.UserRegisterRepository;
import com.kdu.model.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetails implements UserDetailsService {
    private final UserRegisterRepository userRegisterRepository;

    @Autowired
    public CustomUserDetails(UserRegisterRepository userRegisterRepository) {
        this.userRegisterRepository = userRegisterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> optionalUserModel = userRegisterRepository.findByUsername(username);
        UserModel userModel = null;
        if(optionalUserModel.isPresent())   userModel = optionalUserModel.get();
        String personUserName;
        String personPassword;
        List<GrantedAuthority> authorities;

        if (userModel == null) {
            throw new UsernameNotFoundException("User details not found for user: ".concat(username).concat(". Please register first."));
        } else {
            personUserName = userModel.getUsername();
            personPassword = userModel.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(userModel.getRole()));
        }
        return new User(personUserName, personPassword, authorities);
    }
}
