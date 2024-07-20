package org.example.task3.entity;

import java.util.List;

public class Container {

    List<Test> tests;
    List<Test> values;

    public Container() {
    }

    public Container(List<Test> tests, List<Test> values) {
        this.tests = tests;
        this.values = values;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public List<Test> getValues() {
        return values;
    }

    public void setValues(List<Test> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Container{" +
                "tests=" + tests +
                ", values=" + values +
                '}';
    }
}
