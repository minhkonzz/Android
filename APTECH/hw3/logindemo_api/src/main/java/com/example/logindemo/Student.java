package com.example.logindemo;

public class Student {
    private final String name;
    private final long id;
    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
