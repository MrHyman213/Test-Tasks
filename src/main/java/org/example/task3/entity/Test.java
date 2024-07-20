package org.example.task3.entity;

import java.util.List;

public class Test {

    private int id;
    private String title;
    private String value;

    private List<Test> values;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        return id == test.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Test> getValues() {
        return values;
    }

    public void setValues(List<Test> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", values=" + values +
                '}';
    }
}
