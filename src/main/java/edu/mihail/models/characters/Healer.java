package edu.mihail.models.characters;

import edu.mihail.models.contracts.Character;

import edu.mihail.utils.Constants;

public class Healer extends Character {
    private static final int healthPoints = Constants.Healer.HEALTH_POINTS;

    public Healer() {
        setHealth();
    }

    public static int heal(Character character) {
        return character.getHealth() + healthPoints;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    private void setHealth() {
        this.health = Constants.Healer.INITIAL_HEALTH;
    }

}
