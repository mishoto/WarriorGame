package edu.test.models;

import edu.mihail.models.Knight;
import edu.mihail.models.Warrior;
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
    void shouldCheckIfWarriorHasHealthOf50() {
        assertAll("Health of Warriors is:",
                () -> assertEquals(50, warriorOne.getHealth()),
                () -> assertEquals(50, warriorTwo.getHealth())
        );
    }

    @Test
    void shouldCheckIfWarriorIsAlive() {
        class HealthTestWarrior extends Warrior {
            public HealthTestWarrior(int health) {
                setHealth(health);
            }
        }
        Warrior warriorPositive = new HealthTestWarrior(50);
        Warrior warriorZero = new HealthTestWarrior(0);
        assertAll("isAlive of Warriors is:",
                () -> {
                    assertTrue(warriorPositive.isAlive());
                },
                () -> {
                    assertFalse(warriorZero.isAlive());
                },
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> new HealthTestWarrior(-20));
                }
        );
    }

    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Hit -> ")
    void shouldCheckIfHitDecrementHealthOfTheInputWarriorByTheCallerAttack() {

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
