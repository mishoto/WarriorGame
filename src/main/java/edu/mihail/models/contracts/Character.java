package edu.mihail.models.contracts;

import edu.mihail.services.AbstractEquipmentService;

import edu.mihail.utils.WeaponUtils;



public abstract class Character {
    public int health;

    public abstract int getHealth();

    public boolean isAlive(){
        return getHealth() > 0;
    }

    public Character equipWithAccessory(AbstractEquipmentService equipmentService){
        return WeaponUtils.createArmyCharacterWithWeaponBonuses(this, equipmentService);
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getName().substring(29) + " " + this.getHealth() + "}";
    }
}
