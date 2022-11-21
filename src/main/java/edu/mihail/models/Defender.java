package edu.mihail.models;

public class Defender extends Warrior {

    private static final int ATTACK = 3;

    public Defender() {
        setHealth(60);
        setDefence(2);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
}
