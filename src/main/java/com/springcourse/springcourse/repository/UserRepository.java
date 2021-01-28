package com.springcourse.springcourse.repository;

import com.springcourse.springcourse.domain.User;
import com.springcourse.springcourse.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM user u WHERE email = ?1 AND password = ?2")
    public Optional<User> login (String email, String password);

    @Transactional(readOnly = false)
    @Modifying
    @Query("UPDATE user SET role = ?2 WHERE id = ?1")
    public int updateRole(Long id, Role role);

    public Optional<User> findByEmail(String email);

}
