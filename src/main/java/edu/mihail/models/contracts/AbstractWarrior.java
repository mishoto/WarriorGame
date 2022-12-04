package edu.mihail.models.contracts;

import edu.mihail.models.characters.Healer;
import edu.mihail.utils.CharacterUtils;

public abstract class AbstractWarrior extends Character implements Healable<Healer>{
    protected int attack;

    public abstract int getAttack();

    public void hit(Character character){
        character.health = CharacterUtils.calculateCharacterDamage(this, character);
    }

    @Override
    public void healBy(Healer healer) {
        this.health = this.getHealth() +  healer.heal(this);
    }
}
