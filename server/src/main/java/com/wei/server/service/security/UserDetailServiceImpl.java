package com.wei.server.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder pe;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("用户名和密码不正确");
        }

        return new User(
                "admin",
                pe.encode("123456"),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin, ROLE_admin")
        );
    }

}
