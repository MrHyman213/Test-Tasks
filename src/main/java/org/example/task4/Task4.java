package org.example.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        try {
            Scanner sc = new Scanner(new File(
                    new Scanner(System.in).nextLine()));
            List<Integer> list = new ArrayList<>();
            while (sc.hasNext()) {
                String value = sc.nextLine();
                list.add(Integer.parseInt(value));
            }
            Collections.sort(list);
            int middle = list.size() / 2;
            int middleValue = list.get(middle);
            int counter = 0;
            for (int i = middle - 1; i >= 0; i--)
                counter += middleValue - list.get(i);
            for (int i = middle; i < list.size(); i++)
                counter += list.get(i) - middleValue;
            System.out.println(counter);
        } catch (FileNotFoundException e) {
            System.out.println("Путь до файла не найден.");
        }
    }
}
