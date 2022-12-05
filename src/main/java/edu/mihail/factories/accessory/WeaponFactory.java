package edu.mihail.factories.accessory;

import edu.mihail.models.accessories.weapons.Weapon;

public class WeaponFactory implements IAccessoryFactory<Weapon> {

    private Weapon createWeaponInstance(Weapon weapon) {

        switch (weapon) {
            case SWORD:
                return Weapon.SWORD;
            case SHIELD:
                return Weapon.SHIELD;
            case GREAT_AXE:
                return Weapon.GREAT_AXE;
            case KATANA:
                return Weapon.KATANA;
            case MAGIC_WAND:
                return Weapon.MAGIC_WAND;
            default:
                throw new IllegalArgumentException("There is no such weapon type!");
        }
    }

    @Override
    public Weapon createAccessory(Weapon weapon) {
        return createWeaponInstance(weapon);
    }
}
