package edu.mihail.services.observerservice;

import edu.mihail.models.aggregates.Army;
import edu.mihail.models.contracts.Character;

import java.util.*;

public class NotificationService {
    private final Map<EventType, List<EventArmyListener>> armySubscribers;
    private final Map<EventType, List<EventCharacterListener>> characterSubscribers;

    public NotificationService() {
        armySubscribers = new HashMap<>();
        Arrays.stream(EventType.values()).forEach(event -> armySubscribers.put(event, new ArrayList<>()));
        characterSubscribers = new HashMap<>();
        Arrays.stream(EventType.values()).forEach(event -> characterSubscribers.put(event, new ArrayList<>()));
    }

    public void subscribe(EventType eventType, EventArmyListener eventArmyListener){
        armySubscribers.get(eventType).add(eventArmyListener);
    }

    public void subscribe(EventType eventType, EventCharacterListener eventCharacterListener){
        characterSubscribers.get(eventType).add(eventCharacterListener);
    }

    public void unsubscribe(EventType eventType, EventArmyListener eventListener){
        armySubscribers.get(eventType).remove(eventListener);
    }

    public void unsubscribe(EventType eventType, EventCharacterListener eventCharacterListener){
        characterSubscribers.get(eventType).remove(eventCharacterListener);
    }

    public void notifyArmy(EventType eventType, Army army){
        armySubscribers.get(eventType).forEach(listener -> listener.updateArmy(eventType, army));
    }

    public void notifyCharacter(EventType eventType, Character character){
        characterSubscribers.get(eventType).forEach(listener -> listener.updateCharacter(eventType, character));
    }
}
