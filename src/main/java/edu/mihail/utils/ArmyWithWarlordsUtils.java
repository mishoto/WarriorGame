package edu.mihail.utils;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.models.contracts.Character;

import java.util.Collections;
import java.util.List;

public class ArmyWithWarlordsUtils {

    private static CharacterType typeFromCharacterInstance;

    private ArmyWithWarlordsUtils(){};

    public static List<Character> deleteAllWarlordsFromTroopExceptOne(List<Character> troop){
        int currentIdx = 0;
        int storeIdx = 0;

        while (true){
            typeFromCharacterInstance = CharacterUtils.getTypeFromCharacterInstance(troop.get(currentIdx));
            if(typeFromCharacterInstance.equals(CharacterType.WARLORD)){
                storeIdx = currentIdx;
                currentIdx = troop.size()-1;
            }
            if(currentIdx == troop.size()-1){
                for (int i = currentIdx; i > storeIdx; i--) {
                    typeFromCharacterInstance = CharacterUtils.getTypeFromCharacterInstance(troop.get(i));
                    if(typeFromCharacterInstance.equals(CharacterType.WARLORD)){
                        troop.remove(i);
                    }
                }
                break;
            }
            currentIdx++;
        }
        return troop;
    }

    public static void moveWarlordToEnd(List<Character> troop) {
        for (int i = 0; i < troop.size(); i++) {
            typeFromCharacterInstance = CharacterUtils.getTypeFromCharacterInstance(troop.get(i));
            if(typeFromCharacterInstance.equals(CharacterType.WARLORD)){
                Collections.swap(troop, i, troop.size()-1);
            }
        }
    }
}
