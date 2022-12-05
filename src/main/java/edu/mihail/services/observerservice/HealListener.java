package edu.mihail.services.observerservice;

import edu.mihail.models.characters.Healer;
import edu.mihail.models.contracts.Character;

public class HealListener implements EventCharacterListener {


    @Override
    public void updateCharacter(EventType eventType, Character character) {
        if(eventType.equals(EventType.HEAL)){
            Healer.heal(character);
        }
    }
}
