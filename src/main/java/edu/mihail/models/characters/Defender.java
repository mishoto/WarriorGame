package edu.mihail.models.characters;

import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.utils.Constants;

public class Defender extends AbstractWarrior {

    public Defender() {
        health = Constants.Defender.INITIAL_HEALTH;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    public int getDefence(){
        return Constants.Defender.DEFENCE;
    }

    @Override
    public int getAttack() {
        return Constants.Defender.ATTACK;
    }
}
