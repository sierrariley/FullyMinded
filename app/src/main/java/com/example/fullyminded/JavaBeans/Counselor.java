package com.example.fullyminded.JavaBeans;

public class Counselor {
    private String name;
    private String credentials;

    public Counselor(String name, String credentials) {
        this.name = name;
        this.credentials = credentials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return name ;
    }
}
