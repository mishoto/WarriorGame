package edu.mihail.models;

public abstract class Character {

    protected int health;

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth(){
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }
}
