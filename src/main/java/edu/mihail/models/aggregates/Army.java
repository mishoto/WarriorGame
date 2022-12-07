package edu.mihail.models.aggregates;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.factories.character.CharacterFactory;
import edu.mihail.models.characters.Warlord;
import edu.mihail.models.contracts.AbstractArmy;
import edu.mihail.models.contracts.Character;
import edu.mihail.services.AbstractEquipmentService;
import edu.mihail.services.observerservice.NotificationService;
import edu.mihail.services.observerservice.EventType;
import edu.mihail.utils.ArmyWithWarlordsUtils;


import java.util.*;
import java.util.stream.Collectors;


public class Army extends AbstractArmy<Character> {

    protected List<Character> troop;
    private final ListIterator<Character> troopIterator;
    private final NotificationService armyNotificationService;

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

        public Army build() {
            return new Army(this);
        }
    }

    private Army(Builder builder) {
        troop = builder.troopBuilder.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        validateTroopWithSingleWarlord(troop);
        troop = armyInitialArrangeIfWarlordIsPresent(troop);
        troopIterator = troop.listIterator();
        armyNotificationService = new NotificationService();
    }

    public Army(List<Character> characterList){
        this.troop = characterList;
        troopIterator = troop.listIterator();
        armyNotificationService = new NotificationService();
    }

    public Character getNextCharacter() {
        return troopIterator.hasNext() ? troopIterator.next() : null;
    }

    public Character getPreviousCharacter(){
        return troopIterator.hasPrevious() ? troopIterator.previous() : null;
    }

    public List<Character> getTroop() {
        return troop;
    }

    public ListIterator<Character> getTroopIterator() {
        return troopIterator;
    }

    public NotificationService getArmyNotificationService() {
        return armyNotificationService;
    }

    public void removeDeadBodies(){
        armyNotificationService.notifyArmy(EventType.REMOVE_DEAD, Army.this);
    }

    public void arrangeArmy(){
        armyNotificationService.notifyArmy(EventType.ARMY_ARRANGE, Army.this);
    }

    private static void validateTroopWithSingleWarlord(List<Character> troop) {
        ArmyWithWarlordsUtils.deleteAllWarlordsFromTroopExceptOne(troop);
        ArmyWithWarlordsUtils.moveWarlordToEnd(troop);
    }

    private static boolean hasWarlordInArmy(List<Character> troop){
        return troop.get(troop.size()-1) instanceof Warlord;
    }

    private static List<Character> armyInitialArrangeIfWarlordIsPresent(List<Character> troop){
        Army army = new Army(troop);
        if(hasWarlordInArmy(army.getTroop())){
            ArmyWithWarlordsUtils.arrangeArmy(army);
        }
        return hasWarlordInArmy(army.getTroop()) ? ArmyWithWarlordsUtils.arrangeArmy(army).getTroop() : army.getTroop();
    }


    @Override
    public String toString() {
        return "Army{" +
                "troop=" + troop +
                '}';
    }
}
