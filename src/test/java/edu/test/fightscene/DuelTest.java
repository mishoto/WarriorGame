package edu.test.fightscene;

import edu.mihail.fightscene.Duel;
import edu.mihail.models.characters.Knight;
import edu.mihail.models.characters.Warrior;
import edu.mihail.models.contracts.AbstractWarrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DuelTest {

    private final AbstractWarrior warriorOne = new Warrior();
    private final AbstractWarrior warriorTwo = new Warrior();
    private final AbstractWarrior knightOne = new Knight();
    private final AbstractWarrior knightTwo = new Knight();
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
