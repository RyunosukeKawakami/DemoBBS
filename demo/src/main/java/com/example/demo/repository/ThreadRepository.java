package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Thread;;

/**
 * ThreadRepository
 */
@Repository
public class ThreadRepository extends JpaRepository<Thread,Integer>{
}