package edu.mihail.fightscene;

import edu.mihail.models.contracts.AbstractWarrior;

public class Duel implements FightStrategy<AbstractWarrior>{

    @Override
    public boolean fight(AbstractWarrior warriorOne, AbstractWarrior warriorTwo) {
        twoWarriorsFightToDeath(warriorOne, warriorTwo);
        return warriorOne.isAlive();
    }

    public static void twoWarriorsFightToDeath(AbstractWarrior warriorOne, AbstractWarrior warriorTwo) {
        while (warriorOne.isAlive() && warriorTwo.isAlive()) {
            warriorOne.hit(warriorTwo);
            if (warriorTwo.getHealth() <= 0) {
                break;
            }
            warriorTwo.hit(warriorOne);
        }
    }
}
