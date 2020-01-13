package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Thread;

/**
 * ThreadRepository
 */
@Repository
public interface ThreadRepository extends CrudRepository<Thread, Integer> {
    public Thread findById(int id);
}