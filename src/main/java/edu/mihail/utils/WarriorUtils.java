package edu.mihail.utils;

import edu.mihail.factories.CharacterType;
import edu.mihail.models.Warrior;

public final class WarriorUtils {

    private WarriorUtils(){}

    public static CharacterType getTypeFromWarriorInstance(Warrior warrior) {
        String packageName = warrior.getClass().getPackageName();
        return CharacterType.valueOf(warrior.getClass().getTypeName().substring(packageName.length() + 1).toUpperCase());
    }

    public static int calculateWarriorHealth(CharacterType characterType, Warrior attackWarrior, Warrior attackedWarrior) {
        int attackedWarriorHealth = attackedWarrior.getHealth() - calculateWarriorDamage(attackWarrior, attackedWarrior);

        switch (characterType) {
            case WARRIOR:
            case KNIGHT:
            case DEFENDER:
            case VAMPIRE:
            case LANCER:
            case HEALER:
                return attackedWarriorHealth;
            default:
                throw new IllegalArgumentException("Wrong Character Type");
        }
    }

    public static int calculateWarriorDamage(Warrior attackWarrior, Warrior attackedWarrior) {
        int attackedWarriorDefence = attackedWarrior.getDefence();
        int attackerAttack = attackWarrior.getAttack();

        return attackedWarriorDefence < attackerAttack ? attackerAttack - attackedWarriorDefence : attackerAttack;
    }
}
