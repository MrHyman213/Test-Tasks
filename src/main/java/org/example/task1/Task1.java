package org.example.task1;

import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution(){
        String[] args = new Scanner(System.in).nextLine().split(" ");
        gettingPath(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }

    private static void gettingPath(int size, int interval){
        int point = 1;
        do {
            System.out.print(point);
            point = (point + interval - 2) % size + 1;
        } while(point != 1);
    }
}
