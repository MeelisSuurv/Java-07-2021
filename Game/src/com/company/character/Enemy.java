package com.company.character;

import com.company.World;

import java.util.Random;

public class Enemy extends Character{

    private EnemyType enemyType;
    private int xCoord;
    private int yCoord;
    private char symbol;

    public Enemy(World world) {
        super('Z', world);


    }
    public void randomiseCoordinates(World world) {
        Random rand = new Random();
        this.xCoord = rand.nextInt(World.getWidth());
        this.yCoord = rand.nextInt(World.getHeight()-2)+1;
        checkCoordinatesUniqueness(world);
        this.enemyType = EnemyType.getRandomEnemyType();
        getHealthByEnemyType();
    }

    private void getHealthByEnemyType() {
        switch (this.enemyType) {
            case RAT:
                this.setHealth(1);
                break;
            case CAT:
                this.setHealth(2);
                break;
            case DOG:
                this.setHealth(3);
                break;
            case GOBLIN:
                this.setHealth(4);
                break;
            case ORC:
                this.setHealth(5);
                break;
            case DRAGON:
                this.setHealth(6);
                break;
            case WIZARD:
                this.setHealth(7);
                break;
        }
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public void loseHealth(int strenght) {
        this.setHealth(getHealth()-strenght);
    }
}
