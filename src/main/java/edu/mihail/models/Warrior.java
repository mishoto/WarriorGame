package edu.mihail.models;

import edu.mihail.utils.Constants;
import edu.mihail.utils.WarriorUtils;


public class Warrior extends Character implements Cloneable {

    private static final int ATTACK = Constants.Warrior.ATTACK;
    private int defence;

    public Warrior() {
        setHealth(Constants.Warrior.INITIAL_HEALTH);
        setDefence(Constants.Warrior.DEFENCE);
    }

    public void hit(Warrior warrior) {
        warrior.health = WarriorUtils.calculateWarriorHealth(WarriorUtils.getTypeFromWarriorInstance(warrior), this, warrior);
    }

    public void hit(Warrior warriorOne, Warrior warriorTwo) {
        this.hit(warriorOne);
        this.hit(warriorTwo);
    }

    @Override
    public Warrior clone() {
        try {
            Warrior clone = (Warrior) super.clone();
            clone.setHealth(this.health);
            clone.setDefence(this.defence);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public int getAttack() {
        return ATTACK;
    }

    public int getDefence() {
        return defence;
    }

    protected void setDefence(int defence) {
        this.defence = defence;
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getName().substring(18) + " " + this.getHealth() + "}";
    }
}
