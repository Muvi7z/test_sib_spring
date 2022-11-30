package com.example.test_spring.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "arr")
public class Array {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "array_id")
    private int arrayId;

    @Column(name = "len")
    private int len;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "array")
    private List<Element> elements;

    public Array() {
    }

    public Array(int len) {
        this.len = len;
    }


    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public int getArrayId() {
        return arrayId;
    }

    public void setArrayId(int arrayId) {
        this.arrayId = arrayId;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
}
