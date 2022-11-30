package com.example.test_spring.controller;

import com.example.test_spring.domain.Array;
import com.example.test_spring.domain.Element;
import com.example.test_spring.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    ElementService elementService;

    @GetMapping(value="/getArrayById/{arrayId}")
    public List<Integer> getArrayById(@PathVariable int arrayId){
        List<Element> elements = elementService.getArrayById(arrayId);
        List<Integer> intElems = new ArrayList<>();
        for (Element elem: elements) {
            intElems.add(elem.getElemVal());
        }
        return intElems;
    }

    @CrossOrigin
    @PostMapping("/addNewArray")
    public boolean addNewArray(@RequestBody List<Integer> elementList){
        System.out.println(elementList);
        List<Element> elements = new ArrayList<>();

        int arrLen = elementList.size();
        Array array = new Array(arrLen);
        for (int i =0; i<arrLen; i++){

            for (int j = 0; j < arrLen-i-1; j++){
                if(elementList.get(j) > elementList.get(j+1)){
                    Collections.swap(elementList, j, j+1);
                }
            }
            elements.add(new Element(elementList.get(arrLen-i-1),arrLen-i,array));
        }
        array.setElements(elements);
        elementService.addArray(array);
        return true;
    }
    @GetMapping(value="/getSchedule")
    public String getSchedule(){

        return "[{\"userId\":46,\"name\":\"Аюева С.И.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"8.00-17.00\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"8.00-17.00\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"8.00-17.00\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"8.00-17.00\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"8.00-17.00\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"8.00-17.00\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"8.00-17.00\",\"line\":true,\"editable\":true,\"indexLine\":0}]},{\"userId\":50,\"name\":\"Базарова Э.Б.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":40,\"name\":\"Балдуева Ю.П.\",\"groups\":3,\"fired\":false,\"line\":false,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":30,\"name\":\"Банзарова С.Д.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0}]},{\"userId\":39,\"name\":\"Белоусова С.А.\",\"groups\":3,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":55,\"name\":\"Борбоева Е.Ц.\",\"groups\":3,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0}]},{\"userId\":49,\"name\":\"Бородина Е.Л.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0}]},{\"userId\":41,\"name\":\"Бородина Н.В.\",\"groups\":3,\"fired\":false,\"line\":false,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":48,\"name\":\"Булутова И.П.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\" 8.30-17.30\",\"line\":true,\"editable\":true,\"indexLine\":0}]},{\"userId\":45,\"name\":\"Вербицкая О.Н.\",\"groups\":3,\"fired\":false,\"line\":false,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":47,\"name\":\"Гармаева А.А.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"о\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"о\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"о\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"о\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"о\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"о\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"о\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":56,\"name\":\"Ихиритова В.Н.\",\"groups\":3,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":32,\"name\":\"Маркина Т.А.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":51,\"name\":\"Михайлова О.Б.\",\"groups\":1,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":26,\"name\":\"Мункуева Е.Г.\",\"groups\":1,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":28,\"name\":\"Надмитова Г.Б.\",\"groups\":1,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":52,\"name\":\"Нимаева Г.С.\",\"groups\":1,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"о\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"о\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"о\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"о\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"о\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"о\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"о\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":31,\"name\":\"Норбоева Д.Ю.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":38,\"name\":\"Прилепова Ю.П.\",\"groups\":3,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":53,\"name\":\"Сазыкина Е.С.\",\"groups\":1,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":29,\"name\":\"Сангаева Н.В.\",\"groups\":1,\"fired\":false,\"line\":false,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":33,\"name\":\"Санжеева В.В.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":27,\"name\":\"Соковикова И.Н.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":34,\"name\":\"Танхаева Е.С.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":54,\"name\":\"Токтонова Е.С.\",\"groups\":1,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"о\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"о\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"10.00-19.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":36,\"name\":\"Хабдаева Т.П.\",\"groups\":3,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":35,\"name\":\"Шагжеева Д.Б.\",\"groups\":2,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"11.00-20.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":44,\"name\":\"Шангина М.Л.\",\"groups\":3,\"fired\":false,\"line\":false,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":37,\"name\":\"Эрдынеева А.С.\",\"groups\":3,\"fired\":false,\"line\":true,\"gen\":0,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"о\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":43,\"name\":\"Алейник Е.И.\",\"groups\":3,\"fired\":false,\"line\":false,\"gen\":1,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]},{\"userId\":42,\"name\":\"Руднева М.С.\",\"groups\":3,\"fired\":false,\"line\":false,\"gen\":1,\"scheduleDays\":[{\"date\":\"2022-10-10\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-11\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-12\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-13\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-14\",\"eventId\":\"я\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-15\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0},{\"date\":\"2022-10-16\",\"eventId\":\"в\",\"startTime\":\"9.00-18.00\",\"line\":false,\"editable\":true,\"indexLine\":0}]}]";
    }
}
