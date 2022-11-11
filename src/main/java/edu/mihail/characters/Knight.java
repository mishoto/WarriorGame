package edu.mihail.characters;

public class Knight extends Warrior{

    private int health;
    private int attack;

    public Knight() {
        this.health = 50;
        this.attack = 7;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    public void hitByWarrior(Warrior warrior){
        health = this.getHealth() - warrior.getAttack();
    }
}
