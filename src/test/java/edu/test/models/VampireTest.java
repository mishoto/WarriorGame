package edu.test.models;

import edu.mihail.models.characters.Defender;
import edu.mihail.models.characters.Knight;
import edu.mihail.models.characters.Vampire;
import edu.mihail.models.characters.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class VampireTest {

    Warrior warrior = new Warrior();
    Knight knight = new Knight();
    Defender defender = new Defender();
    Vampire vampire = new Vampire();

    @Test
    void shouldCheckIfVampireHasAttackOf4() {
                assertEquals(4, vampire.getAttack());
    }

    @Test
    void shouldCheckIfVampireHasHealthOf40() {
                assertEquals(40, vampire.getHealth());
    }

    @Test
    void shouldCheckIfVampireHasVampirismOf50() {
        assertEquals(50, vampire.getVampirism());
    }

    @Test
    void shouldCheckIfHitDecrementHealthOfTheInputWarriorAndIncreaseHealthOfVampire() {

        knight.hit(vampire);
        Assertions.assertEquals(33, vampire.getHealth());
        Assertions.assertEquals(50, knight.getHealth());

        defender.hit(vampire);
        Assertions.assertEquals(30, vampire.getHealth());
        Assertions.assertEquals(60, defender.getHealth());

        vampire.hit(defender);
        Assertions.assertEquals(58, defender.getHealth());
        Assertions.assertEquals(31, vampire.getHealth());

        vampire.hit(knight);
        Assertions.assertEquals(46, knight.getHealth());
        Assertions.assertEquals(33, vampire.getHealth());

        vampire.hit(warrior);
        Assertions.assertEquals(46, warrior.getHealth());
        Assertions.assertEquals(35, vampire.getHealth());
    }
}
