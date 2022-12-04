package edu.mihail.utils;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.models.characters.Defender;
import edu.mihail.models.contracts.Character;
import edu.mihail.models.contracts.AbstractWarrior;

public final class CharacterUtils {

    private CharacterUtils(){}

    public static CharacterType getTypeFromCharacterInstance(Character character) {
        String packageName = character.getClass().getPackageName();
        return CharacterType.valueOf(character.getClass().getTypeName().substring(packageName.length() + 1).toUpperCase());
    }

    public static int calculateCharacterHealthByType(CharacterType characterType, AbstractWarrior attackWarrior, Character attackedCharacter) {
        int attackedCharacterHealth = attackedCharacter.getHealth() - calculateCharacterDamage(attackWarrior, attackedCharacter);

        switch (characterType) {
            case WARRIOR:
            case KNIGHT:
            case DEFENDER:
            case VAMPIRE:
            case LANCER:
            case HEALER:
            case WARLORD:
                return attackedCharacterHealth;
            default:
                throw new IllegalArgumentException("Wrong Character Type");
        }
    }

    public static int calculateCharacterDamage(AbstractWarrior attackWarrior, Character attackedCharacter) {
        int attackerAttack = attackWarrior.getAttack();
        int attackedCharacterHealth = attackedCharacter.getHealth();
        if(attackedCharacter instanceof Defender){
            int defence = ((Defender) attackedCharacter).getDefence();
            attackerAttack = attackerAttack > defence ? attackerAttack - defence : 0;
        }
        return attackedCharacterHealth - attackerAttack;
    }
}
