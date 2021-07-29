package com.company;

import java.util.ArrayList;
import java.util.List;

//nime muutmiseks sõna aktiivseks, parem klõps ja refactor rename
public class Main {

    // main meetodis läheb programm käima ja lõpeb
    public static void main(String[] args) {
//  klass on justkui andmemudel, mis kohustab mingeid väärtusi vastu võtma
        // instanci tekitamiseks pean kõik väärtused lisama õigete väärtustega
        Mammal kass = new Mammal(70, 2, "Miisu", false, false);
        Mammal koer = new Mammal(80, 0, "Muri", false, false);
        Mammal tiiger = new Mammal(140, 5, "King", false, false);
        Mammal rott = new Mammal(10, 1, "Sipsu", false, false);

        rott.printOneChild();

        rott.addChild(new Mammal(2, 0, "SipsiII", true, false));
        kass.addChild(new Mammal(20, 0, "N/A", true, false));
        koer.addChild(new Mammal(50, 0, "N/A", true, false));
        tiiger.addChild(new Mammal(100, 0, "N/A", true, false));

        koer.changeToSold();
        kass.increaseAge();
        koer.increaseAge();

        int koerPrice = koer.getPrice();  //funktsiooni see on return, mis pannakse vasakule
        int kassPrice = kass.getPrice();

        //private kõik muutujad et keegi ligi ei saaks
        //kass.price = 123445;
        int totalprice = kass.getPrice() + koer.getPrice();
        //System.out.println("Ostja koguhind oli " + totalPrice);

        rott.setPrice(20);

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
        List<Animal> koikLoomad = new ArrayList<>();
        koikLoomad.add(kass);
        koikLoomad.add(koer);
        koikLoomad.add(tiiger);
        koikLoomad.add(rott);
        koikLoomad.add(papagoi);
        koikLoomad.add(ookull);
        koikLoomad.add(tihane);
        koikLoomad.add(leevike);

        // foreach + enter
        int koguSumma = 0;
        for (Animal loom : koikLoomad) {
            koguSumma = koguSumma + loom.getPrice();
// 0 = 0 + 70 (kass.getPrice())
            // = 70 + 80 (kassgetPrice())
        }

        System.out.println("Kõikide loomade ostmiseks kogusumma " + koguSumma);
    }
}
