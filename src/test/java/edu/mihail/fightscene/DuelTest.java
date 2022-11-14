package edu.mihail.fightscene;

import edu.mihail.characters.Knight;
import edu.mihail.characters.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DuelTest {

    private final Warrior warriorOne = new Warrior();
    private final Warrior warriorTwo = new Warrior();
    private final Warrior knightOne = new Knight();
    private final Knight knightTwo = new Knight();

    @Test
    void shouldCheckIfFirstOfTwoWarriorsWhenAttackFirstWillWin(){
        Assertions.assertTrue(Duel.fight(warriorOne, warriorTwo));
    }

    @Test
    void shouldCheckIfFirstOfTwoKnightsWhenAttackFirstWillWin(){
        Assertions.assertTrue(Duel.fight(knightOne, knightTwo));
    }

    @Test
    void shouldCheckIfKnightWhenAttackFirstTheWarriorWillWin(){
        Assertions.assertTrue(Duel.fight(knightOne, warriorOne));
    }

    @Test
    void shouldCheckIfWarriorWhenAttackFirstTheKnightWillWin(){
        Assertions.assertFalse(Duel.fight(warriorOne, knightOne));
    }
}
