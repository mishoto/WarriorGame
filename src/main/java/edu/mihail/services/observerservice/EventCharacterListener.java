package edu.mihail.services.observerservice;

import edu.mihail.models.contracts.Character;

public interface EventCharacterListener {

    void updateCharacter(EventType eventType, Character character);
}
