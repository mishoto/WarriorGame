package edu.mihail.models;

import edu.mihail.utils.Constants;
import edu.mihail.utils.WarriorUtils;

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
        int damage = WarriorUtils.calculateWarriorDamage(this, warriorTwo);
        return warriorHealth - damage/2;
    }
}
