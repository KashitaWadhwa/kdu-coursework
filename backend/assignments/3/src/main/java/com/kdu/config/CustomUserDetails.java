package com.kdu.config;

import com.kdu.dao.UserRegisterRepository;
import com.kdu.model.entity.UserRegister;
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
        Optional<UserRegister> optionalUserModel = userRegisterRepository.findByUsername(username);
        UserRegister userRegister = null;
        if(optionalUserModel.isPresent())   userRegister = optionalUserModel.get();
        String personUserName;
        String personPassword;
        List<GrantedAuthority> authorities;

        if (userRegister == null) {
            throw new UsernameNotFoundException("User details not found for user: ".concat(username).concat(". Please register first."));
        } else {
            personUserName = userRegister.getUsername();
            personPassword = userRegister.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(userRegister.getRole()));
        }
        return new User(personUserName, personPassword, authorities);
    }
}
