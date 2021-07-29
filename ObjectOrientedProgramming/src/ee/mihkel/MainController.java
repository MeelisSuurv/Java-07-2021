package ee.mihkel;

import java.sql.SQLOutput;
import java.util.List;

public class MainController {


    public static void addChildrentoMammal(Mammal mammal) {
        mammal.addChild(new Mammal(2, 0, "Sipsi II", true, false, mammal.getMammalType()));
        mammal.addChild(new Mammal(2, 0, "Sapsu", true, false, mammal.getMammalType()));
        mammal.addChild(new Mammal(2, 0, "Micky", true, false, mammal.getMammalType()));
        mammal.addChild(new Mammal(2, 0, "Minni", true, false, mammal.getMammalType()));
        mammal.addChild(new Mammal(2, 0, "Mootorrattur hiir", true, false, mammal.getMammalType()));
    }

    public static void calculateObjectSum(Mammal koer, Mammal kass) {
        koer.changeToSold(); // siin on void, kuna pole vasakule poole muutujasse midagi panna
        kass.changeToSold();
        kass.increaseAge();
        koer.increaseAge();

        int koerPrice = koer.getPrice(); // siin on mingi tagastus (funktsiooni sees on return), mis pannakse vasakule
        int kassPrice = kass.getPrice();

//        keerasin Private-ks kõik muutujad, seega ei saa neile otse ligi
//        kass.price = 1312312312;
//        int totalPrice = kass.price + koer.price;
        int totalPrice = koerPrice + kassPrice;
        System.out.println("Ostja koguhind oli: " + totalPrice);
//        System.out.println("Ostja koguhind oli: " + totalPrice);
//        System.out.printf("Ostja koguhind oli %d %s", totalPrice, " eurot");
//        System.out.printf("Ostja koguhind oli %d %s", 23, " dollarit");
    }

    public static void printObjects(List<Animal> animals) {
        for (Animal a : animals) {
            System.out.println(a);
        }
    }

    public static void calculateTotalAmmount(List<Animal> animals) {

        int koguSumma = 0;
        for (Animal loom : animals) {
            koguSumma = koguSumma + loom.getPrice();
//             = 0 + 70 (kass.getPrice())
//             = 70 + 80 (koer.getPrice())
        }
//        for (Bird lind:koikLinnud) {
//            koguSumma += lind.getPrice();
//        }
        System.out.println("Kõikide loomade ostmiseks kogusumma: " + koguSumma);
    }

    public static void setAndPrintReptileCount(Reptile krokodill, Reptile kilpkonn, Reptile sisalik) {
        //krokodill.increaseFamilyCount();
        System.out.println(krokodill.getFamilyCount());
        Reptile.increaseBreedCount();
        kilpkonn.increaseFamilyCount();
        System.out.println(kilpkonn.getFamilyCount());
        Reptile.increaseBreedCount();
        sisalik.increaseFamilyCount();
        System.out.println(sisalik.getFamilyCount());
        Reptile.increaseBreedCount();
        System.out.println(Reptile.getBreedCount());

    }
}


