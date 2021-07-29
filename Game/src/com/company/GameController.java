package com.company;

import com.company.character.Enemy;
import com.company.character.Player;
import com.company.character.QuestMaster;
import com.company.item.Item;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public abstract class GameController {
    public static int seconds;

    public static int getSeconds() {
        return seconds;
    }

    public static void checkIfPlayerCanGetItem(World world, Player player) {

       for (Item i: world.getItems()) {
        if (i.getxCoord() == player.getxCoord() && i.getyCoord() == player.getyCoord()) {
            if (!player.getInventory().contains(i)) {
                player.addToInventory(i);
            } else { i.increaseDurability();
                //world.getItems().stream().filter(i -> i.getyCoord() == player.getyCoord() && i.getxCoord() == player.getxCoord())
                  //      .findAny()
                    //    .ifPresent(Item::increaseDurability);
            }
            }
        }
    }
    public static void playerAndEnemyMet(Player player, Enemy enemy, Scanner scanner) throws GameOverException {
        String input;
        if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord() && enemy.isVisible()) {
            enemy.setVisible(false);
            System.out.println("Kohtusid vaenlasega!");
            if (player.isInventoryEmpty()) {
                System.out.println("Sul pole relvi, et võidelda, mine korja!");
            } else { chooseWeapon(player, enemy, scanner);
            }
        }
    }

    private static void chooseWeapon(Player player, Enemy enemy, Scanner scanner) throws GameOverException {
        String input;
        System.out.println("Vali millist relva tahad: ");
        player.showInventory();

        Item item = null;
        while (item == null) {
            input = scanner.nextLine();
            try {
                item = player.getFromInventory(Integer.parseInt(input));
                item.decreaseDurability(player);
                System.out.println("Valisid relva: " + item.getClass().getName().substring(17));
                fightWithEnemy(player, enemy, scanner, item);
            } catch (NumberFormatException e) {
                System.out.println("Sisestasid numbri asemel tähe, sisesta uuesti!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Sisestasid mittesobiva numbri, sisesta uuesti!");
            }
        }
    }

    private static void fightWithEnemy(Player player, Enemy enemy, Scanner scanner, Item item) throws GameOverException {
        Random rand = new Random();
        while (enemy.getHealth() > 0) {
            System.out.println("Löömiseks ütle üks number 1-3");
            int enemyFightNumber = rand.nextInt(3)+1;
            int playerFightNumber = 0;
            while (playerFightNumber == 0) {
                try {
                    String input = scanner.nextLine();
                    playerFightNumber = Integer.parseInt(input);
                    if (playerFightNumber < 1 || playerFightNumber > 3) {
                        System.out.println("Sisestasid liiga suure või väikese numbri, sisesta uuesti!");
                        playerFightNumber = 0;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Sisestasid vale sümboli, sisesta uuesti");;
                }
            }
            if (enemyFightNumber != playerFightNumber) {
                //enemy.takeHealth();
                item.hit(enemy);
                System.out.println("Võtsid vaenalselt " + item.getStrenght() + " elu! Elusid alles " + enemy.getHealth());
            } else {
                player.takeHealth();
                System.out.println("Kaotasid elu! Elusid alles " + player.getHealth());
            }
            if (player.getHealth() == 0) {
                throw new GameOverException();

            }

        }
        System.out.println("vastane sai surma! Tapetud vaenlase tüüp: " + enemy.getEnemyType());
        player.addToKilledEnemies(enemy.getEnemyType());
    }


    public static void playerAndQuestMasterMet(World world, Player player, Enemy enemy, QuestMaster questMaster) {
        if (player.getxCoord() == questMaster.getxCoord() && player.getyCoord() == questMaster.getyCoord() && questMaster.isVisible()) {
            questMaster.setVisible(false);
            enemy.randomiseCoordinates(world);
            enemy.setVisible(true);

        } else if (!questMaster.isVisible() && !(player.getxCoord() == questMaster.getxCoord() && player.getyCoord() == questMaster.getyCoord())){
            questMaster.setVisible(true);
        }
    }

    public static void startTimer(Timer timer) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seconds++;
            }
        },1000, 1000);
    }
}
