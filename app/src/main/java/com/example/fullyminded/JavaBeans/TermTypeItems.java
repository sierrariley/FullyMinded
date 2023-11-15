package com.example.fullyminded.JavaBeans;

public class TermTypeItems {
    private static String description;
    private String name;
//    private String description;


    public TermTypeItems(String name, String description ) {
        this.name = name;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return name + "\n" + description ;
    }


}
