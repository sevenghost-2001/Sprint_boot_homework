package com.exercise45.baitap.bai2.services.Imps;

import com.exercise45.baitap.bai2.DTO.Response.UserResponse;
import com.exercise45.baitap.bai2.Utils.JwtHelper;
import com.exercise45.baitap.bai2.entity.Roles;
import com.exercise45.baitap.bai2.entity.UserRoles;
import com.exercise45.baitap.bai2.entity.Users;
import com.exercise45.baitap.bai2.repository.RoleRepository;
import com.exercise45.baitap.bai2.repository.UserRepository;
import com.exercise45.baitap.bai2.repository.UserRoleRepository;
import com.exercise45.baitap.bai2.services.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class UserServicesImps implements UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public UserResponse createUser(String username, String password) {
        if(userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        Users user = new Users();
        user.setUsername(username);
        user.setPasswords(passwordEncoder.encode(password));

        userRepository.save(user);

        Roles roles = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        UserRoles userRole = new UserRoles();
        userRole.setUser(user);
        userRole.setRole(roles);
        userRoleRepository.save(userRole);
        if (user.getUserRoles() == null) {
            user.setUserRoles(new ArrayList<>());
        }
        user.getUserRoles().add(userRole);
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setRoleName(user.getUserRoles().stream().map(userRole1 ->
                userRole.getRole().getName())
                .collect(Collectors.toList()));
        return userResponse;
    }

    @Override
    public String login(String username, String password) {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
        if (passwordEncoder.matches(password, user.getPasswords())) {
            return jwtHelper.generateToken(user.getUsername());
        }else {
            throw new RuntimeException("Invalid password");
        }
    }
}
