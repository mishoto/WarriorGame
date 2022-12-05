package edu.test.services.observerservice;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.models.aggregates.Army;
import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.models.contracts.Character;
import edu.mihail.services.observerservice.EventType;
import edu.mihail.services.observerservice.HealListener;
import org.junit.jupiter.api.Test;

import java.util.List;

class ObserverServiceTest {

    Army army = new Army.Builder()
            .createTroopOf(CharacterType.LANCER, 3)
            .createTroopOf(CharacterType.HEALER, 2)
            .createOneOf(CharacterType.WARLORD)
            .createOneOf(CharacterType.DEFENDER)
            .createTroopOf(CharacterType.KNIGHT, 2)
            .build();



    @Test
            void shouldTestArmyNotificationService(){
        {
            List<Character> armyList = army.getTroop();
            AbstractWarrior abstractWarrior = (AbstractWarrior) armyList.get(0);
            armyList.get(0).getNotificationService().subscribe(EventType.HEAL, new HealListener());

            abstractWarrior.healFirstWarrior();
        }
    }

}
