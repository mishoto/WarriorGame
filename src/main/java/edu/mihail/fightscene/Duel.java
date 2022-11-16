package edu.mihail.fightscene;

import edu.mihail.models.Warrior;

public class Duel implements FightStrategy<Warrior>{

    @Override
    public boolean fight(Warrior warriorOne, Warrior warriorTwo) {
        twoWarriorsFightToDeath(warriorOne, warriorTwo);
        return warriorOne.isAlive();
    }

    public static void twoWarriorsFightToDeath(Warrior warriorOne, Warrior warriorTwo) {
        while (warriorOne.isAlive() && warriorTwo.isAlive()) {
            warriorOne.hit(warriorTwo);
            if (warriorTwo.getHealth() <= 0) {
                break;
            }
            warriorTwo.hit(warriorOne);
        }
    }
}
