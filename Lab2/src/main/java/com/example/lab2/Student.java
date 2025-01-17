package com.example.lab2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private StringProperty id;
    private StringProperty name;
    private StringProperty major;

    public Student(String id, String name, String major) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.major = new SimpleStringProperty(major);
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty majorProperty() {
        return major;
    }
}
