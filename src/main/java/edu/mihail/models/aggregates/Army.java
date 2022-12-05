package edu.mihail.models.aggregates;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.factories.character.CharacterFactory;
import edu.mihail.models.characters.Warlord;
import edu.mihail.models.contracts.AbstractArmy;
import edu.mihail.models.contracts.Character;
import edu.mihail.services.AbstractEquipmentService;
import edu.mihail.utils.ArmyWithWarlordsUtils;
import edu.mihail.utils.CharacterUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;


public class Army extends AbstractArmy<Character> {

    protected List<Character> troop;
    private final ListIterator<Character> troopIterator;

    @Override
    protected Collection<Character> getArmy() {
        return getTroop();
    }

    public static class Builder {
        private final List<List<Character>> troopBuilder = new LinkedList<>();

        public Builder createTroopOf(CharacterType characterType, int quantity) {
            troopBuilder.add(new CharacterFactory().createMany(characterType, quantity));
            return this;
        }

        public Builder createOneOf(CharacterType characterType) {
            troopBuilder.add(new CharacterFactory().createOne(characterType));
            return this;
        }

        public Builder createOneAsArmyCharacter(CharacterType characterType, AbstractEquipmentService abstractEquipmentService) {
            troopBuilder.add(new CharacterFactory().createArmyCharacter(characterType, abstractEquipmentService));
            return this;
        }

        public Army build() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            return new Army(this);
        }
    }

    private Army(Builder builder) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        troop = builder.troopBuilder.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        validateTroopWithSingleWarlord(troop);
//        armyArrangeIfWarlordIsPresent(troop);
        troopIterator = troop.listIterator();
    }

    public Iterator<Character> getTroopIterator() {
        return troopIterator;
    }


    public Character getNextCharacter() {
        return troopIterator.hasNext() ? troopIterator.next() : null;
    }

    public List<Character> getTroop() {
        return troop;
    }

    private void validateTroopWithSingleWarlord(List<Character> troop) {
        ArmyWithWarlordsUtils.deleteAllWarlordsFromTroopExceptOne(troop);
        ArmyWithWarlordsUtils.moveWarlordToEnd(troop);
    }

    public void armyArrangeIfWarlordIsPresent(List<Character> troop) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean hasWarlord = troop
                .stream()
                .anyMatch(s -> CharacterUtils.getTypeFromCharacterInstance(s).equals(CharacterType.WARLORD));
        if(hasWarlord){
            Method move = Warlord.class.getDeclaredMethod("moveUnits");
            move.setAccessible(true);
            move.invoke(troop.get(troop.size()-1));
        }
    }


    @Override
    public String toString() {
        return "Army{" +
                "troop=" + troop +
                '}';
    }
}
