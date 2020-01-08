package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Response;
import org.springframework.data.repository.CrudRepository;

/**
 * ThreadRepository
 */
@Repository
public interface ResponseRepository extends CrudRepository<Response, Integer> {
}