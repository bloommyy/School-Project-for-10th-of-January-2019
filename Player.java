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
public class Player {
    protected String name;
    protected int health;
    protected static int basicDamage = 15;
    protected int damage;
    protected String msg;
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
        this.damage = dmg;
    }
    public int getDamage()
    {
        return this.damage;
    }
    public int getBasicDamage()
    {
        return Player.basicDamage;
    }
    //Methods
    public void doNothing()
    {
        
    }
    //Constructor
}
