package edu.mihail.services.observerservice;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.models.aggregates.Army;
import edu.mihail.models.characters.Warlord;
import edu.mihail.utils.CharacterUtils;

public class ArmyArrangeListener implements EventArmyListener {

    @Override
    public void updateArmy(EventType eventType, Army army) {
        if(eventType.equals(EventType.ARMY_ARRANGE)){
            int lastIndex = army.getTroop().size()-1;
            CharacterType characterType = CharacterUtils.getTypeFromCharacterInstance(army.getTroop().get(lastIndex));
            if(characterType.equals(CharacterType.WARLORD)){
                Warlord.moveUnits();
            }
        }
    }
}
