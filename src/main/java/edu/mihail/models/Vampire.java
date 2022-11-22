package edu.mihail.models;

import edu.mihail.utils.Constants;
import edu.mihail.utils.WarriorUtils;

public class Vampire extends Warrior{

    private static final int ATTACK = Constants.Vampire.ATTACK;
    private static final int VAMPIRISM = Constants.Vampire.VAMPIRISM;
    private int vampireHeal;

    public Vampire() {
        setHealth(Constants.Vampire.INITIAL_HEALTH);
    }

    private int calculateVampireHeal(Warrior warrior, int vampirism){
        int vampirismCoefficient = Math.floorDiv(100, vampirism);
        int damage = WarriorUtils.calculateWarriorDamage(this, warrior);
        return this.health + damage/vampirismCoefficient;
    }

    private void setVampireHeal(Warrior warrior) {
        this.vampireHeal = calculateVampireHeal(warrior, getVampirism());
    }

    @Override
    public void hit(Warrior warrior) {
        super.hit(warrior);
        setVampireHeal(warrior);
        this.setHealth(Math.min(getVampireHeal(), Constants.Vampire.INITIAL_HEALTH));
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    public int getVampireHeal() {
        return vampireHeal;
    }
}
