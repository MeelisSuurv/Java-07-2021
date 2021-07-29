package com.company.character;

import com.company.World;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Character {

    protected int xCoord;
    protected int yCoord;
    private final char symbol;
    private boolean isVisible;
    protected int health;

    public Character(char symbol, World world) {
        Random rand = new Random();
        this.symbol = symbol;
        randomiseCoordinates(world);
        this.isVisible = true;
        this.health = 10;

    }

    private void randomiseCoordinates(World world) {
        Random rand = new Random();
        this.xCoord = rand.nextInt(World.getWidth());
        this.yCoord = rand.nextInt(World.getHeight()-2)+1;

        //this.xCoord = (int) (Math.random() * ((world.getWidth() - 2) + 1));
        //this.yCoord = (int) (Math.random() * ((world.getHeight() - 2) + 1));
        checkCoordinatesUniqueness(world);
    }

    protected void checkCoordinatesUniqueness(World world) {
        List<Character> characters = world.getCharacters();

        List<Character> charactersWithoutThis = characters.stream()
                .filter(c -> c.symbol != this.symbol)
                .collect(Collectors.toList());


        for (Character c : charactersWithoutThis) {
            if (c.getxCoord() == this.xCoord && c.yCoord == this.yCoord) {
                randomiseCoordinates(world);
            }
        }

    }


    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isVisible() {
        return isVisible;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
// playeri jaoks kui kohtub healeriga
    protected void reboost() {
        this.health = 3;

    }

    public int getHealth() {
        return health;
    }

    public void takeHealth() {
        this.health--;
    }
}


