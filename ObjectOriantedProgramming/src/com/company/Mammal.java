package com.company;

import java.util.*;

// pangas konto class
// public int pangajääk

// -1000000
// MAINIS - konto.pangajääk = +100000;

//kui keeran kinni ehk teen muutuja privatiks, siis enam otse ligi ei pääse
// see sätestab tingimused, kuidas ma seda muudan

// -1000000
// LisaPanka(1000)
// VõtaPangast(10000)

public class Mammal extends Animal {
    private boolean isPuppy;
    private int birthYear;
    private MammalType animalType;
    private List<Mammal> children = new ArrayList<>(); // [Animal{}, Animal{}]
    // ArrayListi saab elemente juurde lisada

    // constructor, sulgude sees antakse väärtusi kui see klass luuakse
    public Mammal(int _price, int _age, String _name, boolean _isPuppy, boolean _isSold) {
        super(_price, _age, _name, _isSold);
        this.isPuppy = _isPuppy;
        Calendar calendar = new GregorianCalendar();
        this.birthYear = calendar.get(Calendar.YEAR) - _age;
        this.animalType = animalType;
    }

    public void increaseAge() {
        increaseAgeByOne();
        if (getAge() > 1) {
            this.isPuppy = false;

        }
}


    public List<Mammal> getChildren() {
        return children;
    }

    public void printChildren() {
        for(int i = 0; i < children.size(); i++) {
            System.out.println(i+1 + ". " + children.get(i).getName());
        }
    }
    public void printOneChild() {
        if(children.size() < 1) {
            System.out.println("Sul on valida nende laste seast:");
        printChildren();
        Scanner scanner = new Scanner(System.in);
        String childName = null;

            while (childName == null) {
                System.out.println("Ütle lapse number millist soovid:");
                String input = scanner.nextLine();
                try {
                    int i = Integer.parseInt(input);
                    childName = children.get(i-1).getName();
                    System.out.println("Valisid lapse: " + childName);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
}
    public void addChild(Mammal child) {
        if (this.isPuppy) {
            System.out.println("Tegemist on kutsikaga, lapsi lisada ei saa!");
        } else {
            this.children.add(child);
        }
    }
    @Override
        public String toString() {
            return "Bird{" +
                    "price=" + getPrice() +
                    ", age=" + getAge() +
                    ", name='" + getName() + '\'' +
                    ", isSold=" + isSold() +
                    '}';

        }
    }



