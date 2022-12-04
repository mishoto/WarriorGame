package edu.mihail.fightscene;

import edu.mihail.models.aggregates.Army;
import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.models.contracts.Character;

import java.util.List;

public class Battle implements FightStrategy<Army> {

    @Override
    public boolean fight(Army armyOne, Army armyTwo) {
        List<Character> listOfArmyOne = armyOne.getTroop();
        List<Character> listOfArmyTwo = armyTwo.getTroop();

        AbstractWarrior warriorOfArmyOne = (AbstractWarrior) armyOne.getNextCharacter();
        AbstractWarrior warriorOfArmyTwo = (AbstractWarrior) armyTwo.getNextCharacter();

        boolean onSuccess = !listOfArmyOne.isEmpty();

        while (onSuccess && !listOfArmyTwo.isEmpty()) {
            Duel.twoWarriorsFightToDeath(warriorOfArmyOne, warriorOfArmyTwo);

            if (!warriorOfArmyOne.isAlive()) {
                listOfArmyOne.remove(warriorOfArmyOne);
                warriorOfArmyOne = (AbstractWarrior) armyOne.getNextCharacter();
            } else {
                listOfArmyTwo.remove(warriorOfArmyTwo);
                warriorOfArmyTwo = (AbstractWarrior) armyTwo.getNextCharacter();
            }
        }
        return onSuccess;
    }
}
