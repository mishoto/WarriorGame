package edu.mihail.models.characters;

import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.utils.Constants;

public class Knight extends AbstractWarrior {

    public Knight() {
        health = Constants.Knight.INITIAL_HEALTH;
    }

    @Override
    public int getAttack() {
        return this.attack = Constants.Knight.ATTACK;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

}
