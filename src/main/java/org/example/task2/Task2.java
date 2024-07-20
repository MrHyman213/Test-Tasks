package org.example.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        solution("C:\\Path\\To\\Dir\\file1.txt", "C:\\Path\\To\\Dir\\file2.txt");
    }

    public static void solution(String centerPath, String pointPath){
        try {
            Scanner scanner = new Scanner(new File(centerPath));
            double x = 0;
            double y = 0;
            double radius = 0;
            while (scanner.hasNext()){
                String[] circleInfo = scanner.nextLine().split(" ");
                if(circleInfo.length > 1) {
                    y = Integer.parseInt(circleInfo[0]);
                    x = Integer.parseInt(circleInfo[1]);
                } else radius = Math.pow(Integer.parseInt(circleInfo[0]), 2);
            }
            scanner = new Scanner(new File(pointPath));
            while(scanner.hasNext()){
                String[] point = scanner.nextLine().split(" ");
                double result = Math.pow((Double.parseDouble(point[1]) - x), 2)
                        + Math.pow((Double.parseDouble(point[0]) - y), 2);
                if (result > radius)
                    System.out.println(2);
                else if (result == radius)
                    System.out.println(0);
                else System.out.println(1);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
