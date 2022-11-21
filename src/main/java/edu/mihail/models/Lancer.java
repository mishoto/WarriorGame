package edu.mihail.models;

public class Lancer extends Warrior {

    private static final int ATTACK = 6;

    public Lancer() {
        setHealth(50);
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
