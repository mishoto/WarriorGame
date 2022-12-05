package edu.mihail.models.characters;

import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.utils.Constants;

public class Warlord extends AbstractWarrior {

    public Warlord() {
        setHealth();
    }

    @Override
    public int getAttack() {
        return Constants.Warlord.ATTACK;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    public int getDefence(){
        return Constants.Warlord.DEFENCE;
    }

    private void setHealth(){
        this.health = Constants.Warlord.INITIAL_HEALTH;
    }

    private static void moveUnits(){
        System.out.println("start move()");
    }
}
