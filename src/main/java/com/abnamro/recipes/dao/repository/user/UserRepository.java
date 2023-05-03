package com.abnamro.recipes.dao.repository.user;

import com.abnamro.recipes.dao.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
