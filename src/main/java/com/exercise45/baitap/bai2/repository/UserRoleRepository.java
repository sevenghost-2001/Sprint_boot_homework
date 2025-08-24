package com.exercise45.baitap.bai2.repository;

import com.exercise45.baitap.bai2.entity.UserRoles;
import com.exercise45.baitap.bai2.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles, Integer> {
    List<UserRoles> findByUser(Users user);
}
