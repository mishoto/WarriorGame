package edu.mihail.characters;

public class Warrior {

    private  int health;
    private final int attack;

    public Warrior() {
        this.health = 50;
        this.attack = 5;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isAlive(int health){
        return health > 0;
    }

    public void hitBy(Warrior warrior){
        health = this.getHealth() - warrior.attack;
    }
}
