package com.example.logindemo;

public class Student {
    private final String name;
    private final String address;
    private final long id;
    public Student(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
}
