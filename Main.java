/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.project.pkgfor.pkg10th.of.january.pkg2019;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String charChoice,charName;
        int spellChoice, whoWon = 0;
        Enemies enemy1 = new Enemies();
        Enemies enemy2 = new Enemies("Skeleton", 200, 15, true);
        Scanner scan = new Scanner(System.in);
        do{
        System.out.print("What would you like to play?(Mage/Warrior):");
        charChoice = scan.nextLine();
        }while(!charChoice.equals("Mage") && !charChoice.equals("Warrior"));
        if(charChoice.equals("Mage"))
        {
            Mage magician = new Mage();
            System.out.print("Name your Mage:");
            charName = scan.next();
            magician.setName(charName);
            magician.charInfo();
            do
            {
                do
                {
                    System.out.println("===============================================");
                    System.out.print("Spells : Spell 1(10 mana), Spell 2(20 mana), Spell 3(25 mana), Ultimate(30mana), Heal(10 mana), Runaway, Skip Turn\nPlease choose a spell (with numbers):");
                    spellChoice = scan.nextInt();
                    if(spellChoice > 7 || spellChoice < 1)
                    {
                        System.out.println("There is no such spell number, please choose a number between 1 and 7.");
                    }
                }while(spellChoice > 7 || spellChoice < 1);
                System.out.println("===============================================");
                if(spellChoice == 1)
                {
                    magician.SpellOne(enemy1, enemy2);
                }else if(spellChoice == 2)
                {
                    magician.SpellTwo(enemy1, enemy2);
                }else if(spellChoice == 3)
                {
                    magician.SpellThree(enemy1, enemy2);
                }else if(spellChoice == 4)
                {
                    magician.Ultimate(enemy1, enemy2);
                }else if(spellChoice == 5)
                {
                    magician.Heal();
                }else if(spellChoice == 6){
                    magician.Runaway();
                    whoWon = 2;
                    break;
                }else if(spellChoice == 7){
                    magician.doNothing();
                }
                if(enemy1.getHealth() <= 0)
                {
                    whoWon = 1;
                    break;
                }
                //===================================================Your spells^
                System.out.println("===============================================");
                enemy1.attackOne(magician, null, charChoice);
                System.out.println("===============================================");
                magician.setMana(magician.getMana() + 5);
                System.out.printf("It's the end of the round so %s got 5 mana!\n",magician.name);
                System.out.println(magician);
                System.out.println(enemy1);
                if(magician.getHealth() <= 0)
                {
                    whoWon = 2;
                    break;
                }
                //===================================================Enemy attack^        
            }while(magician.getHealth() >0 || enemy1.getHealth() > 0);
            if(whoWon == 1)
            {
                System.out.println("===============================================");
                System.out.println("Congratulations, YOU WON!");
                System.out.println("===============================================");
            }else{
                System.out.println("===============================================");
                System.out.println("You will get him next time, champ!");
                System.out.println("===============================================");
            }
        }else{
            Warrior melee = new Warrior();
            System.out.print("Name your Warrior:");
            charName = scan.next();
            melee.setName(charName);
            melee.charInfo();
            do
            {
                do
                {
                    System.out.println("===============================================");
                    System.out.print("Spells : Normal Attack(20 energy), Block(20 energy), Buff Attack(40 energy), Super Slash Combo(50 energy), Armor Up(10 energy), Runaway, Skip Turn\nPlease choose a spell (with numbers):");
                    spellChoice = scan.nextInt();
                    if(spellChoice > 7 || spellChoice < 1)
                    {
                        System.out.println("There is no such spell number, please choose a number between 1 and 7.");
                    }
                }while(spellChoice > 7 || spellChoice < 1);
                System.out.println("===============================================");
                if(spellChoice == 1)
                {
                    melee.NormalAttack(enemy1, enemy2);
                }else if(spellChoice == 2)
                {
                    melee.BlockAttack();
                }else if(spellChoice == 3)
                {
                    melee.BuffAttack();
                }else if(spellChoice == 4)
                {
                    melee.SuperSlashCombo(enemy1, enemy2);
                }else if(spellChoice == 5)
                {
                    melee.armorUp();
                }else if(spellChoice == 6){
                    melee.Runaway();
                    whoWon = 2;
                    break;
                }else if(spellChoice == 7){
                    melee.doNothing();
                }
                if(enemy1.getHealth() <= 0)
                {
                    whoWon = 1;
                    break;
                }
                //===================================================Your spells^
                System.out.println("===============================================");
                enemy1.attackOne(null, melee, charChoice);
                System.out.println("===============================================");
                if(melee.getHealth() <= 0)
                {
                    whoWon = 2;
                    break;
                }
                melee.setEnergy(melee.getEnergy() + 5);
                System.out.printf("It's the end of the round so %s got 5 energy!\n", melee.getName());
                System.out.println(melee);
                System.out.println(enemy1);
                //===================================================Enemy attack^
            }while(melee.getHealth() >0 || enemy1.getHealth() > 0);
            if(whoWon == 1)
            {
                System.out.println("===============================================");
                System.out.println("Congratulations, YOU WON!");
                System.out.println("===============================================");
            }else{
                System.out.println("===============================================");
                System.out.println("You will get him next time, champ!");
                System.out.println("===============================================");
            }
        } 
    }  
}