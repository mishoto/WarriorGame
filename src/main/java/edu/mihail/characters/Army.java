package edu.mihail.characters;

import java.util.Collection;

public class Army {

    Warrior warrior;
    Collection<Warrior> troop;

    public void addUnits(){
        troop.add(warrior);
    }

    public int armySize(){
        return troop.size();
    }

    public boolean isArmyAlive(){
        return armySize() > 0;
    }
}
