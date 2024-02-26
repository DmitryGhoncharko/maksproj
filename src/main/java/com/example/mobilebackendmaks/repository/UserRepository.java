package com.example.mobilebackendmaks.repository;

import com.example.mobilebackendmaks.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("SELECT u FROM User u WHERE u.userId != :userId")
    List<User> findAllByUserIdIsNotContaining(String userId);
    @Query("SELECT u FROM User u WHERE u.userId NOT IN (:userIdList)")
    List<User> findAllByUserIdIsNotContaining(List<String> userIdList);
    @Query("SELECT u FROM User u WHERE u.userId IN (:userIdList)")
    List<User> findAllByUserIdIsContaining(List<String> userIdList);
    List<User> findAllByFullName(String fullName);


}
