package edu.mihail.services.observerservice;

import edu.mihail.models.aggregates.Army;
import edu.mihail.models.characters.Warlord;


public class ArmyArrangeListener implements EventArmyListener {

    @Override
    public void updateArmy(EventType eventType, Army army) {
        if(eventType.equals(EventType.ARMY_ARRANGE)){
           Warlord.moveUnits(army);
        }
    }
}
