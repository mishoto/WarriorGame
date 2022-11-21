package edu.mihail.models;

import edu.mihail.utils.Constants;

public class Defender extends Warrior {

    private static final int ATTACK = Constants.Defender.ATTACK;

    public Defender() {
        setHealth(Constants.Defender.INITIAL_HEALTH);
        setDefence(Constants.Defender.DEFENCE);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
}
