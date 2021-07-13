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

public class Animal {
    public int Price;
    private int price;
    private int age;
    private String name;
    private boolean isPuppy;
    private boolean isSold;
    private int birthYear;
    private AnimalType animalType;
    private List<Animal> children = new ArrayList<>(); // [Animal{}, Animal{}]
    // ArrayListi saab elemente juurde lisada

    // constructor, sulgude sees antakse väärtusi kui see klass luuakse
    public Animal(int _price, int _age, String _name, boolean _isPuppy, boolean _isSold, AnimalType _animalType) {
        this.price = _price;
        this.age = _age;
        this.name = _name;
        this.isPuppy = _isPuppy;
        this.isSold = _isSold;
        Calendar calendar = new GregorianCalendar();
        this.birthYear = calendar.get(Calendar.YEAR) - _age;
        this.animalType = _animalType;
    }

    public void changeToSold() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kas on vajalikud dokumendid esitatud?");
        String input = scanner.nextLine();
        if (input.equals("jah")){
            this.isSold = true;
            System.out.println("Müüdud!");
        } else {
            System.out.println("Ei saa dokumentideta müüa!");
        }


        this.isSold = true;

    }
public void increaseAge() {
        this.age++;
        if (this.age > 0) {
            this.isPuppy = false;

        }
}

public void changePrice(int newPrice) {
        this.price = newPrice;
}

public int getPrice() {
        return this.price;
}

    public List<Animal> getChildren() {
        return children;
    }

    public void addChild(Animal child) {
        if (this.isPuppy) {
            System.out.println("Tegemist on kutsikaga, lapsi lisada ei saa!");
        } else {
            this.children.add(child);
        }

    }

    @Override
    public String toString() {
        return "Animal{" +
                "price=" + price +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", isPuppy=" + isPuppy +
                ", isSold=" + isSold +
                ", birthYear=" + birthYear +
                ", animalType=" + animalType +
                '}';
    }
}
