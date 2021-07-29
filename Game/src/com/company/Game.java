package com.company;

import com.company.character.Character;
import com.company.character.Enemy;
import com.company.character.Player;
import com.company.character.QuestMaster;
import com.company.item.Dagger;
import com.company.item.Hammer;
import com.company.item.Item;
import com.company.item.Sword;

import java.util.Scanner;
import java.util.Timer;

public class Game {

    // Enemy saab surma ja tema elud pannakse uuesti täis
    // Enemytel on erinevad tüübid erinevate eludega
    // Kui enemy saab surma, siis salvestatakse MAP tüüpi masiivi tema tüüp ja mitu korda teda on tapetud
    // itemitel str kasutusele võtmine ja vastavalt tugevusele elude võtmine
    // itemType kasutuselevõtmine - korrutada str läbi ItemType-ga
    // ItemType muutub paremaks ehk leveli tõstmine ja kontroll kui on jõudnud mingi levelini
    // Salvestada sekundid mitu sekundit mängija elude lõpuni jääb
    // Item - Transporter, millega saab põgeneda
    // Uus Character nimega Healer, kes peidetud ehk ilma Sümbolita ja kes ravib juhuslikult elud täis


    // Angularis veebipood - võtame tooted ja hakkame neid kuvama, saab ostukorvi lisada,
    // Saab tooteid admin juurde lisada, kustutada
    // Backend võtab need lisamised, muutmised ja kustutamised vastu ja salvesab andmebaasi
    // Java Spring + Hibernate

    public static void main(String[] args) {

    World world = new World(5, 6);
    Timer timer = new Timer();
    GameController.startTimer(timer);
    Player player = new Player(world);

    Enemy enemy = new Enemy(world);
	world.addCharacter(enemy);

        QuestMaster questMaster = new QuestMaster(world);
        world.addCharacter(questMaster);
        world.addCharacter(player);

        Sword sword = new Sword(world);
        world.addItem(sword);
        Dagger dagger = new Dagger(world);
        world.addItem(dagger);
        Hammer hammer = new Hammer(world);
        world.addItem(hammer);

	world.printMap();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            while(!input.equals("end")) {
                player.move(input, world);

                GameController.checkIfPlayerCanGetItem(world, player);
                GameController.playerAndEnemyMet(player, enemy, scanner);
                GameController.playerAndQuestMasterMet(world, player, enemy, questMaster);
                world.printMap();
                input = scanner.nextLine();
            } timer.cancel();


        } catch (GameOverException e) {
            System.out.println("Said surma, mäng läbi!");
            player.showKilledEnemies();
            timer.cancel();
            System.out.println("Kokku läks aega: " + GameController.getSeconds() + " sekundit");
        }
        //if (player_health / 1) {
          //  System.out.println("SAID SURMA");
        }


}



