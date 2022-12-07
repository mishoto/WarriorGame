package edu.mihail.utils;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.models.aggregates.Army;
import edu.mihail.models.contracts.Character;

import java.util.*;


public class ArmyWithWarlordsUtils {

    private static CharacterType typeFromCharacterInstance;

    private ArmyWithWarlordsUtils() {
    }

    public static List<Character> deleteAllWarlordsFromTroopExceptOne(List<Character> troop) {
        int currentIdx = 0;
        int storeIdx = 0;

        while (true) {
            typeFromCharacterInstance = CharacterUtils.getTypeFromCharacterInstance(troop.get(currentIdx));
            if (typeFromCharacterInstance.equals(CharacterType.WARLORD)) {
                storeIdx = currentIdx;
                currentIdx = troop.size() - 1;
            }
            if (currentIdx == troop.size() - 1) {
                for (int i = currentIdx; i > storeIdx; i--) {
                    typeFromCharacterInstance = CharacterUtils.getTypeFromCharacterInstance(troop.get(i));
                    if (typeFromCharacterInstance.equals(CharacterType.WARLORD)) {
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
            if (typeFromCharacterInstance.equals(CharacterType.WARLORD)) {
                Collections.swap(troop, i, troop.size() - 1);
            }
        }
    }

    public static Army arrangeArmy(Army army) {
        Map<CharacterType, List<Character>> armyWarriors = new HashMap<>(collectAllArmyWarriors(army));

        String[] stringTypeForFirstWarrior = new String[]{"LANCER", "KNIGHT", "WARRIOR", "DEFENDER", "VAMPIRE", "HEALER", "ARMYCHARACTER", "WARLORD"};
        List<Character> newArmy = new ArrayList<>();
        //add by character type priority at FIRST position
        addFirstWarriorToArrangedArmy(armyWarriors, stringTypeForFirstWarrior, newArmy);
        //add by character type priority for the next positions
        String[] stringTypeForNextWarriors = new String[]{"HEALER", "LANCER", "KNIGHT", "WARRIOR", "DEFENDER", "VAMPIRE", "ARMYCHARACTER", "WARLORD"};
        for (int i = 0; i < stringTypeForNextWarriors.length; i++) {
            addAllWarriorsFromTypeToArrangedArmy(CharacterType.valueOf(stringTypeForNextWarriors[i]), armyWarriors, newArmy);
        }
        return new Army(newArmy);
    }

    private static void addFirstWarriorToArrangedArmy(Map<CharacterType, List<Character>> armyWarriors, String[] stringType, List<Character> newArmy) {
        for (int i = 0; i < armyWarriors.keySet().size(); i++) {
            List<Character> characterList = armyWarriors.get(CharacterType.valueOf(stringType[i]));
            if (!characterList.isEmpty()) {
                newArmy.add(characterList.get(0));
                characterList.remove(characterList.get(0));
                break;
            }
        }
    }


    private static void addAllWarriorsFromTypeToArrangedArmy(CharacterType characterType, Map<CharacterType, List<Character>> armyWarriors, List<Character> newArmy) {
        if (!armyWarriors.get(characterType).isEmpty()) {
            newArmy.addAll(armyWarriors.get(characterType));
            armyWarriors.replace(characterType, new ArrayList<>());
        }
    }


    private static Map<CharacterType, List<Character>> collectAllArmyWarriors(Army army) {
        List<Character> characterList = army.getTroop();
        Map<CharacterType, List<Character>> characterMap = Map.ofEntries(
                Map.entry(CharacterType.LANCER, new ArrayList<>()),
                Map.entry(CharacterType.KNIGHT, new ArrayList<>()),
                Map.entry(CharacterType.WARRIOR, new ArrayList<>()),
                Map.entry(CharacterType.DEFENDER, new ArrayList<>()),
                Map.entry(CharacterType.VAMPIRE, new ArrayList<>()),
                Map.entry(CharacterType.HEALER, new ArrayList<>()),
                Map.entry(CharacterType.WARLORD, new ArrayList<>()),
                Map.entry(CharacterType.ARMYCHARACTER, new ArrayList<>())
        );

        addAllWarriorsToValuesPerCharacterType(characterList, characterMap);
        return characterMap;
    }

    private static void addAllWarriorsToValuesPerCharacterType(List<Character> characterList, Map<CharacterType, List<Character>> characterMap) {
        for (int i = 0; i < characterList.size(); i++) {
            String characterClass = characterList.get(i).getClass().getName().substring(29).toUpperCase();
            if (!characterMap.keySet().isEmpty() && characterMap.containsKey(CharacterType.valueOf(characterClass))) {
                characterMap.get(CharacterType.valueOf(characterClass)).add(characterList.get(i));
            }
        }
    }
}
