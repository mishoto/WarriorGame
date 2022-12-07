package edu.mihail.models.characters;

import edu.mihail.models.aggregates.Army;
import edu.mihail.models.contracts.AbstractWarrior;
import edu.mihail.utils.ArmyWithWarlordsUtils;
import edu.mihail.utils.Constants;

public class Warlord extends AbstractWarrior {

    public Warlord() {
        health = Constants.Warlord.INITIAL_HEALTH;
    }

    @Override
    public int getAttack() {
        return Constants.Warlord.ATTACK;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    public int getDefence(){
        return Constants.Warlord.DEFENCE;
    }

    public static void moveUnits(Army army){
        ArmyWithWarlordsUtils.arrangeArmy(army);
    }
}
