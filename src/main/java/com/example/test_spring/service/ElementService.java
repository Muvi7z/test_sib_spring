package com.example.test_spring.service;

import com.example.test_spring.domain.Array;
import com.example.test_spring.domain.Element;

import java.util.List;

public interface ElementService {
    public List<Element> getArrayById(int id);
    public void addArray(Array array);
}
