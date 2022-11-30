package com.example.test_spring.repos;

import com.example.test_spring.domain.Array;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArrayRepository extends CrudRepository<Array, Integer> {
}
