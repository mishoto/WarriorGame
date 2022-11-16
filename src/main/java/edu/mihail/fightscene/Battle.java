package edu.mihail.fightscene;

import edu.mihail.models.Army;
import edu.mihail.models.Warrior;

import java.util.List;

public class Battle implements FightStrategy<Army> {

    @Override
    public boolean fight(Army armyOne, Army armyTwo) {
        List<Warrior> listOfArmyOne = armyOne.getArmy();
        List<Warrior> listOfArmyTwo = armyTwo.getArmy();
        Warrior warriorOfArmyOne = armyOne.getNextWarrior();
        Warrior warriorOfArmyTwo = armyTwo.getNextWarrior();
        boolean onSuccess = !listOfArmyOne.isEmpty();

        while (onSuccess && !listOfArmyTwo.isEmpty()) {
            Duel.twoWarriorsFightToDeath(warriorOfArmyOne, warriorOfArmyTwo);
            if (!warriorOfArmyOne.isAlive()) {
                listOfArmyOne.remove(warriorOfArmyOne);
                warriorOfArmyOne = armyOne.getNextWarrior();
            } else {
                listOfArmyTwo.remove(warriorOfArmyTwo);
                warriorOfArmyTwo = armyTwo.getNextWarrior();
            }
        }
        return onSuccess;
    }


}
