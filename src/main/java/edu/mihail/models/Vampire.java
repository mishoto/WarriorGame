package edu.mihail.models;

public class Vampire extends Warrior{

    private static final int ATTACK = 4;
    private static final int VAMPIRISM = 50;

    public Vampire() {
        this.setHealth(40);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hit(Warrior warrior) {
        super.hit(warrior);
        int vampireHeal = calculateVampireHeal(warrior, getVampirism());

        if(vampireHeal > 40){
            this.setHealth(40);
        }else{
            setHealth(vampireHeal);
        }
    }

    private int calculateVampireHeal(Warrior warrior, int vampirism){
        int vampirismCoefficient = Math.floorDiv(100, vampirism);
        int damage = super.calculateWarriorDamage(warrior);
        return this.health + damage/vampirismCoefficient;
    }
}
