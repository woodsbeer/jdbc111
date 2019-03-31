package com.example.jdbc111.bean;

import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.stereotype.Component;

import java.io.Serializable;

public class Dog implements Serializable {
    String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
