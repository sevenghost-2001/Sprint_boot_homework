package com.exercise45.baitap.bai2.services.service;

import com.exercise45.baitap.bai2.DTO.Response.UserResponse;
import com.exercise45.baitap.bai2.entity.Users;

public interface UserServices {
    UserResponse createUser(String username, String password);
    String login(String username, String password);
}
