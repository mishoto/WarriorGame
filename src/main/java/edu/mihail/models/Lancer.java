package edu.mihail.models;

import edu.mihail.utils.Constants;

public class Lancer extends Warrior {

    private static final int ATTACK = Constants.Lancer.ATTACK;

    public Lancer() {
        setHealth(Constants.Lancer.INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void hit(Warrior warriorOne, Warrior warriorTwo) {
        super.hit(warriorOne);
        warriorTwo.health = calculateSecondWarriorHealth(warriorTwo);
    }

    private int calculateSecondWarriorHealth(Warrior warriorTwo){
        int warriorHealth = warriorTwo.getHealth();
        int damage = super.calculateWarriorDamage(warriorTwo);
        return warriorHealth - damage/2;
    }
}
