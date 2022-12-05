package edu.mihail.models.characters;

import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.utils.Constants;

public class Defender extends AbstractWarrior {

    public Defender() {
        setHealth();
    }

    @Override
    public int getHealth() {
        return this.health;
    }


    public int getDefence(){
        return Constants.Defender.DEFENCE;
    }

    private void setHealth() {
        this.health = Constants.Defender.INITIAL_HEALTH;
    }

    @Override
    public int getAttack() {
        return Constants.Defender.ATTACK;
    }
}
