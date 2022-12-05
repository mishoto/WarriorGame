package edu.mihail.services.observerservice;

import edu.mihail.models.aggregates.Army;

public class RemoveDeadListener implements EventArmyListener {

    @Override
    public void updateArmy(EventType eventType, Army army) {
        if(eventType.equals(EventType.REMOVE_DEAD)){
            for (int i = 0; i < army.getTroop().size(); i++) {
                if(!army.getTroop().get(i).isAlive()){
                    army.getTroop().remove(army.getTroop().get(i));
                }
            }
        }
    }
}
