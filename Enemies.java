/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.project.pkgfor.pkg10th.of.january.pkg2019;

import java.util.Random;

/**
 *
 * @author User
 */
public class Enemies {
    protected String name, msg;
    protected int health;
    protected int damage;
    protected boolean isDead = false;
    Random rand = new Random();
    //Getters and Setters
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    
    public void setHealth(int health)
    {
        this.health = health;
    }
    public int getHealth()
    {
        return this.health;
    }
    
    public void setDamage(int dmg)
    {
        this.damage = rand.nextInt(30) + 10;
    }
    public int getDamage()
    {
        return this.damage;
    }
    
    public void setDead(boolean dead)
    {
        this.isDead = dead;
    }
    public boolean getDead()
    {
        return this.isDead;
    }
    //Methods
    public void attackOne(Mage magician, Warrior melee, String choice)
    {
        this.setDamage(rand.nextInt(30) + 10);
        if(choice.equals("Mage"))
        {
            magician.setHealth(magician.getHealth() - this.damage);
            System.out.printf("%s dealt %d damage to %s.\n", this.name, this.damage, magician.getName());
        }else{
            if(melee.getBlockIsUp() == true)
            {
                System.out.printf("%s had activated Block so %s's damage has been blocked!\n", melee.name, this.name);
                melee.setBlockIsUp(false);
            }else{
                if(melee.getArmorIsUp() == true)
                {
                    if(melee.getArmor() - this.damage >= 0)
                    {
                        melee.setArmor(melee.getArmor() - this.damage);
                        if(melee.getArmor() - this.damage == 0)
                        {
                            melee.setArmorIsUp(false);
                        }
                    }else{
                        melee.setArmor(melee.getArmor() - this.damage);
                        melee.setArmor(melee.getArmor() * (-1));
                        melee.setHealth(melee.getHealth() - melee.getArmor());
                        melee.setArmor(0);
                        melee.setArmorIsUp(false);
                    }
                }else{
                    melee.setHealth(melee.getHealth() - this.damage);
                }
                System.out.printf("%s dealt %d damage to %s.\n", this.name, this.damage, melee.getName());
            }
        }
    }
    
    @Override
    public String toString()
    {
        msg = this.name + " has " + this.health + " health.";
        return msg;
    }
    //Consctructor
    public Enemies()
    {
        this.name = "Normal Zombie";
        this.health = 300;
        this.damage = rand.nextInt(30) + 10;
    }
    
    public Enemies(String name, int health, int damage, boolean dead)
    {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.isDead = dead;
    }
}
