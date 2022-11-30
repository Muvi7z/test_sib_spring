package com.example.test_spring.repos;

import com.example.test_spring.domain.Array;
import com.example.test_spring.domain.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElementRepository extends JpaRepository<Element, Integer> {
    public List<Element> findAllByArrayOrderByPosition(Array array);
    public List<Element> findAllByArray(Array array);
}
