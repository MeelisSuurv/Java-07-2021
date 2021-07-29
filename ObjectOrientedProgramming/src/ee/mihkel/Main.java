package ee.mihkel;

import java.util.*;

// nime muutmiseks: sõna aktiivseks, parem klõps, refactor, rename
public class Main {

    //    main meetodis läheb programm käima
    public static void main(String[] args) {

//        Animal animal = new Animal(10,10,"bla"); animali tegime abstract klassiks, enam ei saa instantsi luua

//        klass on justkui nagu andmemudel - ta kohustab väärtusi vastu võtma
//        instantsi tekitamiseks pean kõik väärtused lisama koos õigete tüüpidega
        Mammal kass = new Mammal(70, 2, "Miisu", false, MammalType.KASS);
        Mammal koer = new Mammal(80, 0, "Muri", true, MammalType.KOER);
        Mammal tiiger = new Mammal(140, 5, "King", false, MammalType.TIIGER);
        Mammal tiiger2 = new Mammal(140, 5, "Kong", false, MammalType.TIIGER);
        Mammal rott = new Mammal(10, 1, "Sipsi", false, true, MammalType.ROTT);

        MainController.addChildrentoMammal(rott);
        MainController.addChildrentoMammal(kass);

        //rott.printOneChild();

        //MainController.calculateObjectSum(koer, kass);

        //rott.setPrice(20);


        Bird papagoi = new Bird(45, 1, "Praagu", BirdColor.RED_YELLOW);
        Bird ookull = new Bird(55, 10, "Luigi", BirdColor.BROWN);
        Bird tihane = new Bird(40, 1, "Tihha", BirdColor.BLUE_YELLOW);
        Bird leevike = new Bird(50, 60, "Leevi", BirdColor.RED);

        try {
            leevike.increaseBirdAge();
        } catch (Exception e) {
            e.printStackTrace();
        }


//        pean importima Listi ja ArrayListi java.util-st
        List<Animal> koikLoomad = new ArrayList<>();
//        koikLoomad.add(kass);
        //       koikLoomad.add(koer);
        //      koikLoomad.add(rott);
        //      koikLoomad.add(papagoi);
//        koikLoomad.add(ookull);
//        koikLoomad.add(tihane);
//        koikLoomad.add(leevike);
        koikLoomad = Arrays.asList(kass, koer, tiiger, tiiger2, rott, papagoi, ookull, tihane, leevike);

        MainController.printObjects(koikLoomad);
       // MainController.calculateTotalAmmount(koikLoomad);

        Reptile krokodill = new Reptile(99, "Gena", "Venemaa");
        Reptile kilpkonn = new Reptile(160, "Mutant", "Keenia");
        Reptile sisalik = new Reptile(50, "Sissi", "Brasiilia");

        //MainController.setAndPrintReptileCount(krokodill, sisalik, kilpkonn);

//        foreach + enter
        Map<MammalType, Integer> animalsCount = new HashMap<>();
        animalsCount.put(MammalType.KASS, 7);

                }
            }



//    main meetodi lõppedes programm lõpetab töötamise

