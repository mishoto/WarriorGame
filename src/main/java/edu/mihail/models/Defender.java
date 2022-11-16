package edu.mihail.models;

public class Defender extends Warrior {

    private static final int ATTACK = 3;
    private static final int DEFENCE = 2;

    public Defender() {
        health = 60;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getDefence() {
        return DEFENCE;
    }
}
