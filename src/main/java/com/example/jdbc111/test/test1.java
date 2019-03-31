package com.example.jdbc111.test;

import com.example.jdbc111.bean.Dog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    @Autowired
    Dog d;
    public String dogName(){
        return  d.getName();
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> tl = new ArrayList<>();
        tl.add(2);
        tl.add(3);

        list.add(1);
        list.set(0,11);
        list.addAll(tl);
        System.out.println(list);
        
    }
}
