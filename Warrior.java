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
//The warropr class is made to set and get properties from the Getters and Setters, not set them with this.property.
public class Warrior extends Player implements iRunaway, iArmorUp{
    private int energy;
    private int armor = 0;
    private boolean blockIsUp = false;
    private boolean ArmorIsUp = false;
    private boolean buffAttack = false;
    //Getters and Setters
    public void setEnergy(int energy)
    {
        this.energy = energy;
    }
    public int getEnergy()
    {
        return this.energy;
    }
    
    public void setBlockIsUp(boolean block)
    {
        this.blockIsUp = block;
    }
    public boolean getBlockIsUp()
    {
        return this.blockIsUp;
    }
    
    public void setArmor(int armor)
    {
        this.armor = armor;
    }
    public int getArmor()
    {
        return this.armor;
    }
    
    public void setArmorIsUp(boolean armorIsUp)
    {
        this.ArmorIsUp = armorIsUp;
    }
    public boolean getArmorIsUp()
    {
        return this.ArmorIsUp;
    }
    
    public void setBuffAttack(boolean buf)
    {
        this.buffAttack = buf;
    }
    public boolean getBufAttack()
    {
        return this.buffAttack;
    }
    //Interfaces
    @Override
    public void armorUp()
    {
        if(this.energy - 10 >= 0)
        {
            this.setArmorIsUp(true);
            this.setArmor(this.getArmor() + 10);
            this.setEnergy(this.getEnergy() - 10);
            System.out.printf("%s got 10 armor!\n",this.name);
        }else{
            System.out.println("Not enough energy!");
        }
    }
    @Override
    public void Runaway()
    {
        this.setHealth(0);
        System.out.println("You ran away!");
    }
    //Methods
    public void BlockAttack()
    {
        if(this.energy - 20 >= 0)
        {
            this.setBlockIsUp(true);
            this.setEnergy(this.getEnergy() - 20);
            System.out.printf("%s will block the next enemy attack!\n",this.getName());
        }else{
            System.out.println("Not enough energy!");
        }
    }
    
    public void NormalAttack(Enemies enemy1, Enemies enemy2)
    {
        if(this.energy - 20 >= 0)
        {
            this.setDamage(this.getBasicDamage() + 20);
            if(this.getBufAttack() == true)
            {
                this.setDamage(this.getDamage() * 2);
                this.setBuffAttack(false);
            }
            this.setEnergy(this.getEnergy() - 20);
            if(enemy1.getDead() == false)
            {
                enemy1.setHealth(enemy1.getHealth()-this.damage);
                System.out.printf("%s used Normal Attack and hit %s for %d damage!\n", this.name, enemy1.getName(), this.damage);
                System.out.printf("%s now has %d hp.\n",enemy1.getName(),enemy1.getHealth());
            }else{
                enemy2.setHealth(enemy2.getHealth()-this.damage);
                System.out.printf("%s used Normal Attack and hit %s for %d damage!\n", this.name, enemy2.getName(), this.damage);
                System.out.printf("%s now has %d hp.\n",enemy2.getName(),enemy2.getHealth());
            }
        }else{
            System.out.println("Not enough energy!");
        }
    }
    
    public void BuffAttack()
    {
        if(this.energy - 40 >= 0)
        {
            this.setBuffAttack(true);
            this.setEnergy(this.getEnergy() - 40);
            System.out.println("Your next attack is improved and will deal bonus damage!");
        }else{
            System.out.println("Not enough energy!");
        }
    }
    
    public void SuperSlashCombo(Enemies enemy1, Enemies enemy2)
    {
        if(this.energy - 50 >= 0)
        {
            this.setDamage(this.getBasicDamage() + 70);
            if(this.getBufAttack() == true)
            {
                this.setBuffAttack(false);
                this.setDamage(this.getDamage() * 2);
            }
            this.setEnergy(this.getEnergy() - 50);
            if(enemy1.getDead() == false)
            {
                enemy1.setHealth(enemy1.getHealth()-this.getDamage());
                System.out.printf("%s used Super Slash Combo and hit %s for %d damage!\n", this.name, enemy1.getName(), this.getDamage());
                System.out.printf("%s now has %d hp.\n",enemy1.getName(),enemy1.getHealth());
            }else{
                enemy2.setHealth(enemy2.getHealth()-this.getDamage());
                System.out.printf("%s used Super Slash Combo and hit %s for %d damage!\n", this.name, enemy2.getName(), this.getDamage());
                System.out.printf("%s now has %d hp.\n",enemy2.getName(),enemy2.getHealth());
            }
        }else{
            System.out.println("Not enough energy!");
        }
    }
    
    @Override
    public String toString()
    {
        msg = this.getName() + " has " + this.getHealth() + " health, " + this.getEnergy() + " energy and " + this.getArmor() + " armor!";
        return this.msg;
    }
    
    public void charInfo()
    {
        System.out.printf("Name:%s\nHealth:%d\nEnergy:%d\nArmor:%d\nBasic Damage:%d\n", this.name, this.health, this.energy, this.armor, super.getBasicDamage());
    }
    
    @Override
    public void doNothing()
    {
        System.out.printf("%s skipped his turn.\n",this.getName());
    }
    //Constructor
    public Warrior()
    {
        this.name = "Warrior";
        this.energy = 100;
        this.health = 100;
    }
}
