package edu.mihail.models.characters;

import edu.mihail.models.contracts.Character;

import edu.mihail.utils.Constants;

public class Healer extends Character {
    private static final int HEALTH_POINTS = Constants.Healer.HEALTH_POINTS;

    public Healer() {
        health = Constants.Healer.INITIAL_HEALTH;
    }

    public static int heal(Character character) {
        return character.getHealth() + HEALTH_POINTS;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    public int getHealthPoints(){
        return HEALTH_POINTS;
    }

}
