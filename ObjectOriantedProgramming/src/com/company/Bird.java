package com.company;

import java.util.Scanner;

public class Bird extends Animal {

    private BirdColor birdColor;

    //PAREM KLÕPS GENERATE CONSTRUCTOR
    public Bird(int price, int age, String name, BirdColor birdColor) {
        super(price, age, name);
        this.birdColor = birdColor;
    }


    public BirdColor getBirdColor() {
        return birdColor;
    }

    public void setBirdColor(BirdColor birdColor) {
        this.birdColor = birdColor;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "price=" + getPrice() +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                ", isSold=" + isSold() +
                ", birdColor=" + birdColor +
                '}';
    }
}
