package edu.mihail.models.characters;

import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.models.contracts.Character;
import edu.mihail.utils.Constants;

public class Lancer extends AbstractWarrior {


    public Lancer() {
        setHealth();
    }

    @Override
    public int getAttack() {
        return Constants.Lancer.ATTACK;
    }

    public void hit(Character character, Character... characters) {
        super.hit(character);
        for (int i = 0; i < characters.length; i++) {
            characters[i].health = calculateNextCharacterHealth(characters[i]);
        }
    }

    private int calculateNextCharacterHealth(Character nextCharacter){
        int characterHealth = nextCharacter.getHealth();
        int lancerNextAttack = getAttack()/2;
        return characterHealth - lancerNextAttack;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setHealth() {
        this.health = Constants.Lancer.INITIAL_HEALTH;
    }
}
