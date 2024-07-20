package org.example.task3;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.example.task3.entity.Container;
import org.example.task3.entity.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Task3 {

    public static void main(String[] args) {
        solution("C:\\Path\\To\\Dir\\tests.json", "C:\\Path\\To\\Dir\\values.json", "C:\\Path\\To\\Dir\\");
    }

    public static void solution(String valuesPath, String testsPath, String reportPath){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        File values = new File(valuesPath);
        File tests = new File(testsPath);
        File report = new File(reportPath + "report.json");
        try {
            Container testsCon = mapper.readValue(values, mapper.getTypeFactory().constructType(Container.class));
            Container valuesCon = mapper.readValue(tests, mapper.getTypeFactory().constructType(Container.class));
            List<Test> testsList = testsCon.getTests();
            List<Test> valuesList = valuesCon.getValues();
            for (Test test: testsList){
                for (Test value: valuesList) {
                    if (test.getId() == value.getId()) {
                        test.setValue(value.getValue() != null ? value.getValue() : "");
                    }
                    if (test.getValues() != null)
                        setValue(test.getValues(), value.getId(), value.getValue());
                }
            }
            System.out.println(testsList);
            mapper.writeValue(report, testsList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setValue(List<Test> values, int id, String value){
        for (Test test: values) {
            if (test.getId() == id)
                test.setValue(value);
            if (test.getValues() != null)
                setValue(test.getValues(), id, value);
        }
    }
}
