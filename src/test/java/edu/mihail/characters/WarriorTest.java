package edu.mihail.characters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    private final Warrior warriorOne = new Warrior();
    private final Warrior warriorTwo = new Warrior();
    private final Warrior knightOne = new Knight();
    private final Knight knightTwo = new Knight();

    @Test
    void shouldCheckIfWarriorHasAttackOf5() {
        assertAll("Attack of Warriors is:",
                () -> assertEquals(5, warriorOne.getAttack()),
                () -> assertEquals(5, warriorTwo.getAttack()),
                () -> assertNotEquals(5, knightOne.getAttack()),
                () -> assertNotEquals(5, knightTwo.getAttack())
        );
    }

    @Test
    void shouldCheckIfWarriorHasHealthOf50(){
        assertAll("Health of Warriors is:",
                () -> assertEquals(50, warriorOne.getHealth()),
                () -> assertEquals(50, warriorTwo.getHealth())
        );
    }

    @Test
    void shouldCheckIfWarriorIsAlive(){
        assertAll("isAlive of Warriors is:",
                () -> assertTrue(warriorOne.isAlive(5)),
                () -> assertFalse(warriorOne.isAlive(0)),
                () -> assertFalse(warriorOne.isAlive(-10)),
                () -> assertTrue(knightOne.isAlive(1)),
                () -> assertFalse(knightOne.isAlive(0)),
                () -> assertFalse(knightOne.isAlive(-5))
        );
    }

    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Hit -> ")
    void shouldCheckIfHitDecrementHealthOfTheInputWarriorByTheCallerAttack(){

        warriorOne.hit(warriorTwo);
        assertEquals(45, warriorTwo.getHealth());
        assertEquals(50, warriorOne.getHealth());

        warriorTwo.hit(warriorOne);
        assertEquals(45, warriorTwo.getHealth());
        assertEquals(45, warriorOne.getHealth());

        knightOne.hit(warriorOne);
        assertEquals(38, warriorOne.getHealth());
        assertEquals(50, knightOne.getHealth());

        warriorOne.hit(knightOne);
        assertEquals(38, warriorOne.getHealth());
        assertEquals(45, knightOne.getHealth());

        knightOne.hit(knightTwo);
        assertEquals(45, knightOne.getHealth());
        assertEquals(43, knightTwo.getHealth());
    }
}
