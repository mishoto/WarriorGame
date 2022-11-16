package edu.mihail.fightscene;

import edu.mihail.models.Knight;
import edu.mihail.models.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DuelTest {

    private final Warrior warriorOne = new Warrior();
    private final Warrior warriorTwo = new Warrior();
    private final Warrior knightOne = new Knight();
    private final Knight knightTwo = new Knight();
    private final Duel duel = new Duel();

    @Test
    void shouldCheckIfFirstOfTwoWarriorsWhenAttackFirstWillWin(){
        Assertions.assertTrue(duel.fight(warriorOne, warriorTwo));
    }

    @Test
    void shouldCheckIfFirstOfTwoKnightsWhenAttackFirstWillWin(){
        Assertions.assertTrue(duel.fight(knightOne, knightTwo));
    }

    @Test
    void shouldCheckIfKnightWhenAttackFirstTheWarriorWillWin(){
        Assertions.assertTrue(duel.fight(knightOne, warriorOne));
    }

    @Test
    void shouldCheckIfWarriorWhenAttackFirstTheKnightWillWin(){
        Assertions.assertFalse(duel.fight(warriorOne, knightOne));
    }
}
