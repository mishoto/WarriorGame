package edu.mihail.characters;

public class Knight extends Warrior{

    private final int health;
    private final int attack;

    public Knight() {
        this.health = 50;
        this.attack = 7;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attack;
    }
}
