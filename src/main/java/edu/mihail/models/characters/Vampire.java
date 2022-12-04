package edu.mihail.models.characters;

import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.models.contracts.Character;
import edu.mihail.utils.Constants;
import edu.mihail.utils.CharacterUtils;

public class Vampire extends AbstractWarrior {

    private int vampireHeal;

    public Vampire() {
        setHealth(Constants.Vampire.INITIAL_HEALTH);
    }

    private int calculateVampireHeal(Character character, int vampirism){
        int vampirismCoefficient = Math.floorDiv(100, vampirism);
        int damage = CharacterUtils.calculateCharacterDamage(this, character);
        return this.getHealth() + damage/vampirismCoefficient;
    }

    private void setVampireHeal(Character character) {
        this.vampireHeal = calculateVampireHeal(character, getVampirism());
    }

    @Override
    public void hit(Character character) {
        super.hit(character);
        setVampireHeal(character);
        setHealth(Math.min(getVampireHeal(), Constants.Vampire.INITIAL_HEALTH));
    }

    @Override
    public int getAttack() {
        return Constants.Vampire.ATTACK;
    }

    public int getVampirism() {
        return Constants.Vampire.VAMPIRISM;
    }

    public int getVampireHeal() {
        return this.vampireHeal;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        this.health = health;
    }
}
