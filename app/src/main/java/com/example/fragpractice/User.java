package com.example.fragpractice;

public class User {
    private String name, status;
    private int age, stateSignal;

    public User(int age, String status, String name, int stateSignal) {
        this.age = age;
        this.status = status;
        this.name = name;
        this.stateSignal = stateSignal;
    }

    public String getName() { return name; }
    public String getStatus() { return status; }
    public int getAge() { return age; }
    public int getStateSignal() { return stateSignal; }

    public void setName(String name) { this.name = name; }
    public void setStatus(String status) { this.status = status; }
    public void setAge(int age) { this.age = age; }
    public void setStateSignal(int stateSignal) { this.stateSignal = stateSignal; }
}
