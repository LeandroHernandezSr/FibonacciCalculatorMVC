package com.lhernandez.fibonacci.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lhernandez.fibonacci.app.entities.FibonacciEntity;

public interface FibonacciJpaRepository extends JpaRepository<FibonacciEntity,Long>{
    @Query(value = "SELECT * FROM numbers WHERE number = :num", nativeQuery = true)
    Optional<FibonacciEntity> findByNumber(@Param("num") Integer num);
}
