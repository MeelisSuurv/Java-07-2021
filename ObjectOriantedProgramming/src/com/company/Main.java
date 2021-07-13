package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//nime muutmiseks sõna aktiivseks, parem klõps ja refactor rename
public class Main {

    // main meetodis läheb programm käima ja lõpeb
    public static void main(String[] args) {
//  klass on justkui andmemudel, mis kohustab mingeid väärtusi vastu võtma
        // instanci tekitamiseks pean kõik väärtused lisama õigete väärtustega
        Animal kass = new Animal(70, 2, "Miisu", false, false, AnimalType.KASS);
        Animal koer = new Animal(80, 0, "Muri", false, false, AnimalType.KOER);
        Animal tiiger = new Animal(140, 5, "King", false, false, AnimalType.TIIGER);
        Animal rott = new Animal(10, 1, "Sipsu", false, false, AnimalType.ROTT);

        rott.addChild(new Animal(2, 0, "N/A", true, false));
        kass.addChild(new Animal(20, 0, "N/A", true, false));
        koer.addChild(new Animal(50, 0, "N/A", true, false));
        tiiger.addChild(new Animal(100, 0, "N/A", true, false));

        koer.changeToSold();
        kass.increaseAge();
        koer.increaseAge();

        int koerPrice = koer.getPrice();  //funktsiooni see on return, mis pannakse vasakule
        int kassPrice = kass.getPrice();

        //private kõik muutujad et keegi ligi ei saaks
        //kass.price = 123445;
        int totalprice = kass.Price + koer.Price;
        //System.out.println("Ostja koguhind oli " + totalPrice);

        rott.changePrice(20);

        System.out.println(kass);
        System.out.println(koer);
        System.out.println(tiiger);
        System.out.println(rott);

        System.out.println();

        Bird papagoi = new Bird(45, 1, "Praagu", BirdColor.RED_YELLOW);
        Bird ookull = new Bird(55, 10, "Luigi", BirdColor.BROWN);
        Bird tihane = new Bird(40, 1, "Tihha", BirdColor.BLUE_YELLOW);
        Bird leevike = new Bird(50, 2, "Leevi", BirdColor.RED);

        System.out.println(papagoi);
        System.out.println(ookull);
        System.out.println(tihane);
        System.out.println(leevike);
//pean importima listi ja arraylisti java.utilist
        List<Animal> koikLoomad = new ArrayList<Animal>();
        koikLoomad.add(kass);
        koikLoomad.add(koer);
        koikLoomad.add(tiiger);
        koikLoomad.add(rott);

        List<Bird> koikLinnud = new ArrayList<Bird>();
        koikLinnud.add(papagoi);
        koikLinnud.add(ookull);
        koikLinnud.add(tihane);
        koikLinnud.add(leevike);

        // foreach + enter
        int koguSumma = 0;
        for (Animal loom:koikLoomad) {
            koguSumma = koguSumma + loom.getPrice();
// 0 = 0 + 70 (kass.getPrice())
            // = 70 + 80 (kassgetPrice())
        }
        for (Bird lind:koikLinnud) {
            koguSumma += lind.getPrice();
        }
        System.out.println("Kõikide loomade ostmiseks kogusumma "  + koguSumma);
    }
}
