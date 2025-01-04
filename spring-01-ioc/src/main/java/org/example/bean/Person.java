package org.example.bean;


import lombok.Data;

@Data
public class Person {

    @org.example.annotation.UUID
    private String id;
    private String name;
    private int age;
    private String gender;

    public Person() {
        System.out.println("Person()构造器执行了...");
    }
}
