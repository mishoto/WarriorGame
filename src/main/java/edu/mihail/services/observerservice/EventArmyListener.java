package edu.mihail.services.observerservice;

import edu.mihail.models.aggregates.Army;

public interface EventArmyListener {

    void updateArmy(EventType eventType, Army army);
}
