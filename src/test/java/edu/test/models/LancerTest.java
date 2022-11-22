package edu.test.models;

import edu.mihail.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LancerTest {

    Warrior warrior = new Warrior();
    Knight knight = new Knight();
    Defender defender = new Defender();
    Vampire vampire = new Vampire();
    Lancer lancer = new Lancer();

    @Test
    void shouldCheckIfLancerHasAttackOf6() {
        assertEquals(6, lancer.getAttack());
    }

    @Test
    void shouldCheckIfLancerHasHealthOf50() {
        assertEquals(50, lancer.getHealth());
    }


    @Test
    void shouldCheckIfHitDecrementHealthOfTheFirstInputWarrior() {

        knight.hit(lancer);
        Assertions.assertEquals(43, lancer.getHealth());
        Assertions.assertEquals(50, knight.getHealth());

        lancer.hit(defender);
        Assertions.assertEquals(56, defender.getHealth());
        Assertions.assertEquals(43, lancer.getHealth());

        lancer.hit(defender, knight);
        Assertions.assertEquals(52, defender.getHealth());
        Assertions.assertEquals(47, knight.getHealth());

        lancer.hit(knight, defender);
        Assertions.assertEquals(41, knight.getHealth());
        Assertions.assertEquals(50, defender.getHealth());

    }
}
