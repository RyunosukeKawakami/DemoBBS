package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.entity.Response;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ThreadRepository
 */
@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {
    public List<Response> findAllByThreadId(int thread_id);
    public Response findById(int id);

    public Boolean existsByThreadId(int thread_id);
    @Transactional
    public void deleteByThreadId(int thread_id);
}