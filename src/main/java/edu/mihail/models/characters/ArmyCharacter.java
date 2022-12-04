package edu.mihail.models.characters;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.models.contracts.Character;
import edu.mihail.models.contracts.Healable;


public class ArmyCharacter extends Character implements Healable<Healer> {
        private CharacterType characterType;
        private int attack;
        private int defence;
        private int vampirism;
        private int healPower;

    public ArmyCharacter(CharacterType characterType, int... args) {
        this.characterType = characterType;
        this.attack = args[1];
        this.defence = args[2];
        this.vampirism = args[3];
        this.healPower = args[4];
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getVampirism() {
        return vampirism;
    }

    public void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }

    public int getHealPower() {
        return healPower;
    }

    public void setHealPower(int healPower) {
        this.healPower = healPower;
    }

    @Override
    public void healBy(Healer healer) {
        this.health = this.getHealth() +  healer.heal(this);
    }

    @Override
    public String toString() {
        return "ArmyCharacter{" +
                "characterType=" + characterType +
                ", attack=" + attack +
                ", defence=" + defence +
                ", vampirism=" + vampirism +
                ", healPower=" + healPower +
                '}';
    }
}
