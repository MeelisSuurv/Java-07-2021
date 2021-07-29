package com.company.item;

import com.company.World;
import com.company.character.Character;
import com.company.character.Enemy;
import com.company.character.Player;

import java.util.ArrayList;
import java.util.Random;

public class Item {
    private int strenght;
    public int durability;
    private int level;
    private ItemType itemType;
    private int xCoord;
    private int yCoord;
    private char symbol;

    public Item(int strenght, int durability, World world) {
        this.strenght = strenght;
        this.durability = durability;
        this.level = 0;
        this.itemType = ItemType.BRONZE;
        randomiseCoordinates(world);
        this.symbol = 'I';
    }

    private void randomiseCoordinates(World world) {
        Random rand = new Random();
        //this.xCoord = (int) (Math.random() * ((world.getWidth()-2)+1));
        //this.yCoord = (int) (Math.random() * ((world.getHeight()-2)+1));
        this.xCoord = rand.nextInt(World.getWidth());
        this.yCoord = rand.nextInt(World.getHeight()-2)+1;
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

    public int getDurability() {
        return durability;
    }

    public void increaseDurability() {
        this.durability++;
    }

    @Override
    public String toString() {
        return "Item{" +
                "strenght=" + strenght +
                ", durability=" + durability +
                ", level=" + level +
                ", itemType=" + itemType +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", symbol=" + symbol +
                '}';
    }

    public void decreaseDurability(Player player) {
        if (durability == 1) {
            player.deleteFromInventory(this);
        } else {
            this.durability--;
        }
    }
    public void hit(Enemy enemy) {
        itemType = increaseLevel();
        strenght = getStrenghtByItemType();
        enemy.loseHealth(strenght);
    }

    private ItemType increaseLevel() {
        this.level++;
        switch (this.level/3) {
            case 0:
                return itemType.BRONZE;
            case 1:
                return itemType.SILVER;
            case 2:
                return itemType.GOLD;
            case 3:
                return itemType.PLATINUM;
            default:
                return itemType.BRONZE;
        }
    }

    private int getStrenghtByItemType() {
        switch (this.itemType) {
            case SILVER:
                return (int) (this.strenght*1.5);
            case GOLD:
                return this.strenght*2;
            case PLATINUM:
                return this.strenght*3;
            default:
                return this.strenght;

        }
    }

    public int getStrenght() {
        return strenght;
    }
}
