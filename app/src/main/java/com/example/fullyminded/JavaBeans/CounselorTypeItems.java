package com.example.fullyminded.JavaBeans;

public class CounselorTypeItems {
    private String specialty;

    public CounselorTypeItems(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "CounselorTypeItems{" +
                "specialty='" + specialty + '\'' +
                '}';
    }
}
