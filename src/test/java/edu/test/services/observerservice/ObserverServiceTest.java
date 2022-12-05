package edu.test.services.observerservice;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.models.aggregates.Army;
import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.models.contracts.Character;
import edu.mihail.services.observerservice.ArmyArrangeListener;
import edu.mihail.services.observerservice.EventType;
import edu.mihail.services.observerservice.HealListener;
import edu.mihail.services.observerservice.RemoveDeadListener;
import org.junit.jupiter.api.Test;


class ObserverServiceTest {

    Army army = new Army.Builder()
            .createTroopOf(CharacterType.LANCER, 3)
            .createTroopOf(CharacterType.HEALER, 2)
            .createOneOf(CharacterType.WARLORD)
            .createOneOf(CharacterType.DEFENDER)
            .createTroopOf(CharacterType.KNIGHT, 2)
            .build();



    @Test
            void shouldTestNotificationService(){
        {
            Character firstCharacter = army.getTroop().get(0);
            Character secondCharacter = army.getTroop().get(1);
            Character lastCharacter = army.getTroop().get(army.getTroop().size()-1);

            secondCharacter.getNotificationService().subscribe(EventType.HEAL, new HealListener());
            lastCharacter.getNotificationService().subscribe(EventType.ARMY_ARRANGE, new ArmyArrangeListener());
            army.getArmyNotificationService().subscribe(EventType.REMOVE_DEAD, new RemoveDeadListener());

            firstCharacter.getNotificationService().notifyCharacter(EventType.HEAL, secondCharacter);
            firstCharacter.getNotificationService().notifyCharacter(EventType.ARMY_ARRANGE, lastCharacter);
            lastCharacter.getNotificationService().notifyArmy(EventType.REMOVE_DEAD, army);


        }
    }
}
