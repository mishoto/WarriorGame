package edu.mihail.models;

import edu.mihail.factories.CharacterType;

public class Warrior extends Character implements Cloneable {

    private static final int ATTACK = 5;
    protected int defence = 0;

    public Warrior() {
        setHealth(50);
        setDefence(0);
    }

    public void hit(Warrior warrior) {
        warrior.health = calculateWarriorHealth(getTypeFromWarriorInstance(warrior), warrior);
    }

    public void hit(Warrior warriorOne, Warrior warriorTwo) {
        this.hit(warriorOne);
        this.hit(warriorTwo);
    }

    protected int calculateWarriorHealth(CharacterType characterType, Warrior attackedWarrior) {
        int attackedWarriorHealth = attackedWarrior.getHealth() - calculateWarriorDamage(attackedWarrior);

        switch (characterType) {
            case WARRIOR:
            case KNIGHT:
            case DEFENDER:
            case VAMPIRE:
            case LANCER:
                return attackedWarriorHealth;
            default:
                throw new IllegalArgumentException("Wrong Character Type");
        }
    }

    protected int calculateWarriorDamage(Warrior attackedWarrior) {
        int attackedWarriorDefence = attackedWarrior.getDefence();
        int attackerAttack = this.getAttack();

        return attackedWarriorDefence < attackerAttack ? attackerAttack - attackedWarriorDefence : attackerAttack;
    }

    public static CharacterType getTypeFromWarriorInstance(Warrior warrior) {
        String packageName = warrior.getClass().getPackageName();
        return CharacterType.valueOf(warrior.getClass().getTypeName().substring(packageName.length() + 1).toUpperCase());
    }

    @Override
    public Warrior clone() {
        try {
            Warrior clone = (Warrior) super.clone();
            clone.setHealth(this.health);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public int getAttack() {
        return ATTACK;
    }

    public int getDefence() {
        return defence;
    }

    protected void setDefence(int defence) {
        this.defence = defence;
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getName().substring(18) + " " + this.getHealth() + "}";
    }
}
