package com.example.fragpractice;

public class User {
    private String Name, Status;
    private int Age;
    private int StateSignal;

    public int getStateSignal() {
        return StateSignal;
    }

    public void setStateSignal(int stateSignal) {
        StateSignal = stateSignal;
    }
    public int getAge() {
        return Age;
    }

    public String getStatus() {
        return Status;
    }

    public String getName() {
        return Name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setName(String name) {
        Name = name;
    }

    public User(int age, String status, String name, int stateSignal) {
        Age = age;
        Status = status;
        Name = name;
        StateSignal = stateSignal;
    }

}
