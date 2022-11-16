package edu.mihail.models;

public class Warrior extends Character implements Cloneable {

    private static final int ATTACK = 5;

    public Warrior() {
        setHealth(50);
    }

    public void hit(Warrior warrior) {
        warrior.health = warrior.getHealth() - this.getAttack();
    }

    @Override
    public Warrior clone() {
        try {
            Warrior clone = (Warrior) super.clone();
            clone.setHealth(this.health);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return ATTACK;
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getName().substring(18) + " " + this.getHealth() + "}";
    }
}
