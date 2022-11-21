package edu.mihail.models;

import edu.mihail.utils.Constants;

public class Knight extends Warrior {

    private static final int ATTACK = Constants.Knight.ATTACK;

    public Knight() {
        setHealth(Constants.Knight.INITIAL_HEALTH);
        setDefence(Constants.Knight.DEFENCE);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
}
