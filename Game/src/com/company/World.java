package com.company;

import com.company.character.Character;
import com.company.item.Item;
// import java.lang.Character;
import java.util.ArrayList;
import java.util.List;

public class World {
    private static int height;
    private static int width;
    //private final int height;
    //private final int width;
    private final List<Character> characters = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();

    public World(int height, int width) {
        this.height = height;
        this.width = width;

    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void addCharacter(Character character) {
        this.characters.add(character);

    }
    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void printMap() {
        char symbol;
        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height -1) {
                    symbol = '-';
                } else {
                    symbol = ' ';
                }
                for (Item i:items) {
                    if (i.getxCoord() == x && i.getyCoord() == y) {
                        symbol = i.getSymbol();
                    }
                }
                for (Character c:characters) {
                    if (c.getxCoord() == x && c.getyCoord() == y && c.isVisible()) {
                        symbol = c.getSymbol();
                    }
                }
                System.out.print(symbol);
                }
                System.out.print("|");
                System.out.println();

        }
    }
}
