package edu.test.models;


import edu.mihail.models.Defender;
import edu.mihail.models.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


class DefenderTest {

    private final Warrior warriorOne = new Warrior();
    private final Defender defenderOne = new Defender();


    @Test
    void shouldCheckIfWarriorHasHealthOf60(){
        assertEquals(60, defenderOne.getHealth());
    }


    @Test
    void shouldCheckIfHitDecrementHealthOfTheInputWarriorAsDefender() {

        warriorOne.hit(defenderOne);
        Assertions.assertEquals(57, defenderOne.getHealth());
        Assertions.assertEquals(50, warriorOne.getHealth());

        defenderOne.hit(warriorOne);
        Assertions.assertEquals(47, warriorOne.getHealth());
        Assertions.assertEquals(57, defenderOne.getHealth());

    }
}
