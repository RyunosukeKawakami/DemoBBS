package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.UserAccount;

/**
 * UserAccountRepository
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>{
    public boolean existsByUserName(String userName);
}