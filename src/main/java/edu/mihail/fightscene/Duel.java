package edu.mihail.fightscene;

import edu.mihail.characters.Warrior;

public class Duel implements Actions<Warrior> {

    public boolean fight(Warrior warriorOne, Warrior warriorTwo) {

        while (warriorOne.isAlive(warriorOne.getHealth()) && warriorTwo.isAlive(warriorTwo.getHealth())) {
            warriorOne.hit(warriorTwo);
            if (warriorTwo.getHealth() <= 0) {
                break;
            }
            warriorTwo.hit(warriorOne);
        }
        return warriorOne.isAlive(warriorOne.getHealth());
    }
}
