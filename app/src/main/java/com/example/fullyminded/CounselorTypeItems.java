package com.example.fullyminded;

public class CounselorTypeItems {
    private String name;
    private String description;
    private String credentials;

    public CounselorTypeItems(String name, String credentials, String description ) {
        this.name = name;
        this.description = description;
        this.credentials = credentials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
