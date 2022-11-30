package com.example.test_spring.domain;

import javax.persistence.*;

@Entity
@Table(name = "element")
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "elem_val")
    private Integer elemVal;

    private Integer position;

    @ManyToOne()
    @JoinColumn(name="array_id")
    private Array array;


    public Element() {
    }

    public Element(Integer elemVal, Integer position, Array array) {
        this.elemVal = elemVal;
        this.position = position;
        this.array = array;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Array getArray() {
        return array;
    }

    public void setArray(Array array) {
        this.array = array;
    }

    public Integer getElemVal() {
        return elemVal;
    }

    public void setElemVal(Integer elemVal) {
        this.elemVal = elemVal;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
