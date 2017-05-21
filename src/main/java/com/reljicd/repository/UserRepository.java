package com.reljicd.repository;

import com.reljicd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Dusan on 18-May-17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(@Param("email") String email);
    User findByUsername(@Param("username") String username);
}
