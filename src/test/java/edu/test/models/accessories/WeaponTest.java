package edu.test.models.accessories;

import edu.mihail.factories.accessory.IAccessoryFactory;
import edu.mihail.factories.accessory.WeaponFactory;
import edu.mihail.models.accessories.weapons.Weapon;
import org.junit.jupiter.api.Test;

class WeaponTest {

    IAccessoryFactory<Weapon> weaponFactory = new WeaponFactory();

    @Test
            void shouldTestWeaponClass(){
        {
            Weapon weapon = weaponFactory.createAccessory(Weapon.SWORD);
            System.out.println(weapon.getWeaponAttack());
        }
    }

}
