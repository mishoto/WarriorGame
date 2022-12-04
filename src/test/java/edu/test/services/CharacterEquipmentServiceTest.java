package edu.test.services;

import edu.mihail.models.accessories.weapons.Weapon;
import edu.mihail.services.AbstractEquipmentService;
import edu.mihail.services.CharacterEquipmentService;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class CharacterEquipmentServiceTest {

    AbstractEquipmentService characterEquipmentService = new CharacterEquipmentService.Builder()
            .addAccessory(Weapon.SWORD)
            .addAccessory(Weapon.GREAT_AXE)
            .build();

    @Test
            void shouldTestCharacterEquipmentService() {
        {
            Set<Weapon> weaponBag = characterEquipmentService.getAccessories();
            System.out.println(weaponBag);
        }
    }
}
