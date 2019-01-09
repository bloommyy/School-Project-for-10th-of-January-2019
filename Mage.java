/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.project.pkgfor.pkg10th.of.january.pkg2019;

/**
 *
 * @author User
 */
public class Mage extends Player implements iRunaway, iHeal{
    protected int mana;
    //Getters and Setters
    public void setMana(int mana)
    {
        this.mana = mana;
    }
    public int getMana()
    {
        return this.mana;
    }
    
    //Methods
    @Override
    public void Heal()
    {
        if(this.mana - 10 >= 0)
        {
            this.health += 10;
            this.mana = this.mana - 10;
            System.out.println("You healed yourself for 10 health!");
        }else{
            System.out.println("Not enough mana!");
        }
    }
    @Override
    public void Runaway()
    {
        this.health = 0;
        System.out.println("You ran away!");
    }
    public void SpellOne(Enemies enemy1, Enemies enemy2)
    {
        if(this.mana - 10 >= 0)
        {
            this.mana = this.mana - 10;
            this.damage = Player.basicDamage + 10;
            if(enemy1.getDead() == false)
            {
                enemy1.setHealth(enemy1.getHealth()-this.damage);
                System.out.printf("%s used Spell 1 and hit %s for %d damage!\n", this.name, enemy1.getName(), this.damage);
                System.out.printf("%s now has %d hp.\n",enemy1.getName(),enemy1.getHealth());
            }else{
                enemy2.setHealth(enemy2.getHealth()-this.damage);
                System.out.printf("%s used Spell 1 and hit %s for %d damage!\n", this.name, enemy2.getName(), this.damage);
                System.out.printf("%s now has %d hp.\n",enemy2.getName(),enemy2.getHealth());
            }
        }else{
            System.out.println("Not enough mana!");
        }
    }
    public void SpellTwo(Enemies enemy1, Enemies enemy2)
    {
        if(this.mana - 20 >= 0)
        {
            this.mana = this.mana - 20;
            this.damage = Player.basicDamage + 25;
            if(enemy1.getDead() == false)
            {
                enemy1.setHealth(enemy1.getHealth()-this.damage);
                System.out.printf("%s used Spell 2 and hit %s for %d damage!\n", this.name, enemy1.getName(), this.damage);
                System.out.printf("%s now has %d hp.\n",enemy1.getName(),enemy1.getHealth());
            }else{
                enemy2.setHealth(enemy2.getHealth()-this.damage);
                System.out.printf("%s used Spell 2 and hit %s for %d damage!\n", this.name, enemy2.getName(), this.damage);
                System.out.printf("%s now has %d hp.\n",enemy2.getName(),enemy2.getHealth());
            }
        }else{
            System.out.println("Not enough mana!");
        }
    }
    public void SpellThree(Enemies enemy1, Enemies enemy2)
    {
        if(this.mana - 25 >= 0)
        {
            this.mana = this.mana - 25;
            this.damage = Player.basicDamage + 35;
            if(enemy1.getDead() == false)
            {
                enemy1.setHealth(enemy1.getHealth()-this.damage);
                System.out.printf("%s used Spell 3 and hit %s for %d damage!\n", this.name, enemy1.getName(), this.damage);
                System.out.printf("%s now has %d hp.\n",enemy1.getName(),enemy1.getHealth());
            }else{
                enemy2.setHealth(enemy2.getHealth()-this.damage);
                System.out.printf("%s used Spell 3 and hit %s for %d damage!\n", this.name, enemy2.getName(), this.damage);
                System.out.printf("%s now has %d hp.\n",enemy2.getName(),enemy2.getHealth());
            }
        }else{
            System.out.println("Not enough mana!");
        }
    }
    public void Ultimate(Enemies enemy1, Enemies enemy2)
    {
        if(this.mana - 30 >= 0)
        {
            this.mana = this.mana - 30;
            this.damage = Player.basicDamage + 50;
            if(enemy1.getDead() == false)
            {
                enemy1.setHealth(enemy1.getHealth()-this.damage);
                System.out.printf("%s used Spell 2 and hit %s for %d damage!\n", this.name, enemy1.getName(), this.damage);
                System.out.printf("%s now has %d hp.\n",enemy1.getName(),enemy1.getHealth());
            }else{
                enemy2.setHealth(enemy2.getHealth()-this.damage);
                System.out.printf("%s used Spell 2 and hit %s for %d damage!\n", this.name, enemy2.getName(), this.damage);
                System.out.printf("%s now has %d hp.\n",enemy2.getName(),enemy2.getHealth());
            }
        }else{
            System.out.println("Not enough mana!");
        }
    }
    @Override
    public String toString()
    {
        msg = this.name + " has " + this.health + " health and " + this.mana + " mana!";
        return this.msg;
    }
    
    public void charInfo()
    {
        System.out.printf("Name: %s\nHealth : %d\nMana : %d\nBasic Damage : %d\n", this.name, this.health, this.mana, this.damage);
    }
    
    @Override
    public void doNothing()
    {
        System.out.printf("%s skipped his turn.\n",this.name);
    }
    //Constructor
    public Mage()
    {
        this.name = "Magician";
        this.health = 100;
        this.mana = 100;
        this.damage = this.damage + 5;
    }
}
