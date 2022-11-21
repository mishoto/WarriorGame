package edu.mihail.utils;

import edu.mihail.factories.CharacterType;
import edu.mihail.models.Warrior;

public final class WarriorUtils {

    private WarriorUtils(){}

    public static CharacterType getTypeFromWarriorInstance(Warrior warrior) {
        String packageName = warrior.getClass().getPackageName();
        return CharacterType.valueOf(warrior.getClass().getTypeName().substring(packageName.length() + 1).toUpperCase());
    }
}
