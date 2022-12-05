package edu.mihail.models.characters;

import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.utils.Constants;

public class Knight extends AbstractWarrior {

    public Knight() {
        setHealth();
    }

    @Override
    public int getAttack() {
        return this.attack = Constants.Warrior.ATTACK;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setHealth() {
        this.health = Constants.Knight.INITIAL_HEALTH;
    }
}
