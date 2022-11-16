package edu.mihail.models;

public abstract class Character {

    protected int health;

    public boolean isAlive(int health) {
        return health > 0;
    }

    public abstract int getHealth();


}
