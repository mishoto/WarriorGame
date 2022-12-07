package edu.mihail.models.characters;


import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.utils.Constants;

public class Warrior extends AbstractWarrior {

    public Warrior() {
        health = Constants.Warrior.INITIAL_HEALTH;
    }

    @Override
    public int getAttack() {
        return this.attack = Constants.Warrior.ATTACK;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

}
