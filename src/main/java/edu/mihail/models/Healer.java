package edu.mihail.models;

import edu.mihail.utils.Constants;

public class Healer extends Character{

    public Healer() {
        setHealth(Constants.Healer.INITIAL_HEALTH);
    }

    public void heal(Warrior prevWarrior){
        prevWarrior.health = prevWarrior.getHealth() + Constants.Healer.HEALTH_POINTS;
    }
}
