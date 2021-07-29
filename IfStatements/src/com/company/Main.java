package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
// int tüüpi numbritega on võimalik arvutusi teha
// string tüüpi muutujatega on võimalik võtta esimene, viimane, uppercase ja lowercase
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta oma vanus: ");
        String input = scanner.nextLine();
        int inputAsNumber = Integer.parseInt(input);


        if (inputAsNumber < 19 ) {
            System.out.println("Oled täisealine!");
        } else {
            System.out.println("oled alaealine!");
        }

        List array = new ArrayList();
        array.add("sink");
        array.add("coca");
        array.add("sai");
        array.add("vorst");
        array.add("õlu");
        array.add("toiduõli");
// ["sai", "piim", "õlu", "vorst", "või", "coca", "toiduõli"]

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        for (Object s: array) {
            System.out.println(s);
        }
        int j = 0;
        while (j == 0) {
            System.out.println(array.get(j));
        }

        int result = 0;
        do {
            j = j + 1;
            result = result + j;

        }while (false);

    }
}
