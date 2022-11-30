package com.example.test_spring.service;

import com.example.test_spring.domain.Array;
import com.example.test_spring.domain.Element;
import com.example.test_spring.repos.ArrayRepository;
import com.example.test_spring.repos.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ElementServiceImp implements ElementService{
    @Autowired
    private ElementRepository elementRepository;

    private final ArrayRepository arrayRepository;

    public ElementServiceImp(ArrayRepository arrayRepository) {
        this.arrayRepository = arrayRepository;
    }

    @Override
    public List<Element> getArrayById(int id) {
       Array array = null;
        Optional<Array> arrayOptional = arrayRepository.findById(id);
        if( arrayOptional.isPresent()) {
            array = arrayOptional.get();
            return elementRepository.findAllByArrayOrderByPosition(array);
        }
        return new ArrayList<>();
    }

    @Override
    public void addArray(Array array) {
        arrayRepository.save(array);
    }
}
