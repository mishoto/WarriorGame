package edu.test.models;


import edu.mihail.models.characters.Knight;
import edu.mihail.models.contracts.AbstractWarrior;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class KnightTest {

    AbstractWarrior knight = new Knight();

    @Test
    void shouldCheckIfKnightHasAttackOf7(){
        assertEquals(7, knight.getAttack());
    }

    @Test
    void shouldCheckIfKnightHasHealthOf50(){
        assertEquals(50, knight.getHealth());
    }
}
