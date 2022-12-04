package edu.mihail.models.aggregates;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.factories.character.CharacterFactory;
import edu.mihail.models.contracts.AbstractArmy;
import edu.mihail.models.contracts.Character;
import edu.mihail.services.AbstractEquipmentService;
import edu.mihail.utils.ArmyWithWarlordsUtils;

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

        public Builder createOneOf(CharacterType characterType){
            troopBuilder.add(new CharacterFactory().createOne(characterType));
            return this;
        }

        public Builder createOneAsArmyCharacter(CharacterType characterType, AbstractEquipmentService abstractEquipmentService){
            troopBuilder.add(new CharacterFactory().createArmyCharacter(characterType, abstractEquipmentService));
            return this;
        }

        public Army build() {
            return new Army(this);
        }
    }

    private Army(Builder builder) {
        troop = builder.troopBuilder.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        validateTroopWithSingleWarlord(troop);
        troopIterator = troop.listIterator();
    }

    public Iterator<Character> getTroopIterator() {
        return troopIterator;
    }


    public Character getNextCharacter(){
        return troopIterator.hasNext() ? troopIterator.next() : null;
    }

    public List<Character> getTroop() {
        return troop;
    }

    private void validateTroopWithSingleWarlord(List<Character> troop){
        ArmyWithWarlordsUtils.deleteAllWarlordsFromTroopExceptOne(troop);
        ArmyWithWarlordsUtils.moveWarlordToEnd(troop);
    }



    @Override
    public String toString() {
        return "Army{" +
                "troop=" + troop +
                '}';
    }
}
