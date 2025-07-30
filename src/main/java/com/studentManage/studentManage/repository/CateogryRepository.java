package com.studentManage.studentManage.repository;

import com.studentManage.studentManage.DTO.CategoryDTO;
import com.studentManage.studentManage.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CateogryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);
}
