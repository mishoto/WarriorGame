package edu.mihail.models.contracts;

import edu.mihail.services.AbstractEquipmentService;
import edu.mihail.services.observerservice.NotificationService;
import edu.mihail.utils.WeaponUtils;



public abstract class Character {
    public int health;
    protected NotificationService notificationService = new NotificationService();

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

    public NotificationService getNotificationService(){
        return notificationService;
    };
}
