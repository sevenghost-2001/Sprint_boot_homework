package com.exercise45.baitap.bai2.services.Imps;

import com.exercise45.baitap.bai2.entity.UserRoles;
import com.exercise45.baitap.bai2.entity.Users;
import com.exercise45.baitap.bai2.repository.UserRepository;
import com.exercise45.baitap.bai2.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImps implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        List<UserRoles> roles = userRoleRepository.findByUser(user);

        List<GrantedAuthority> authorities = roles.stream()
                .map(role -> (GrantedAuthority) () -> role.getRole().getName())
                .toList();
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPasswords(),
                authorities
        );
    }
}
