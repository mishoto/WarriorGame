package edu.test.models.aggregates;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.models.accessories.weapons.Weapon;
import edu.mihail.models.aggregates.Army;
import edu.mihail.models.contracts.Character;
import edu.mihail.services.CharacterEquipmentService;
import edu.mihail.utils.ArmyWithWarlordsUtils;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;


class ArmyTest {

    private final Army armyWithoutWarlords = new Army.Builder()
            .createTroopOf(CharacterType.HEALER, 3)
            .createOneOf(CharacterType.WARRIOR)
            .createTroopOf(CharacterType.LANCER, 2)
            .createOneOf(CharacterType.VAMPIRE)
            .build();

    private final Army armyWithOneWarlord = new Army.Builder()
            .createTroopOf(CharacterType.HEALER, 1)

            .createTroopOf(CharacterType.WARLORD, 5)
            .createOneOf(CharacterType.WARRIOR)
            .build();

    private final Army armyWith7Warlords = new Army.Builder()
            .createTroopOf(CharacterType.HEALER, 1)
            .createTroopOf(CharacterType.WARLORD, 7)
            .createTroopOf(CharacterType.DEFENDER, 3)
            .createOneOf(CharacterType.WARRIOR)
            .createOneOf(CharacterType.KNIGHT)
            .createOneAsArmyCharacter(CharacterType.DEFENDER, new CharacterEquipmentService.Builder()
                    .addAccessory(Weapon.GREAT_AXE)
                    .addAccessory(Weapon.SWORD)
                    .addAccessory(Weapon.SHIELD)
                    .build())
            .build();

    @Test
    void shouldCheckIfMethodForValidationOfArmyWith_O_Or_One_Warlord_WorksCorrectly(){

        Collection<Character> armyWith_O_Or_One_Warlord = ArmyWithWarlordsUtils
                .deleteAllWarlordsFromTroopExceptOne(armyWithoutWarlords.getTroop());

        System.out.println(armyWith_O_Or_One_Warlord);

        armyWith_O_Or_One_Warlord = ArmyWithWarlordsUtils
                .deleteAllWarlordsFromTroopExceptOne(armyWithOneWarlord.getTroop());
        System.out.println(armyWith_O_Or_One_Warlord);

        armyWith_O_Or_One_Warlord = ArmyWithWarlordsUtils
                .deleteAllWarlordsFromTroopExceptOne(armyWith7Warlords.getTroop());
        System.out.println(armyWith_O_Or_One_Warlord);
    }

    @Test
    void shouldCheckIfWarlordIsAtLastPosition(){

        List<Character> armyWith_O_Or_One_Warlord = ArmyWithWarlordsUtils
                .deleteAllWarlordsFromTroopExceptOne(armyWithOneWarlord.getTroop());

        ArmyWithWarlordsUtils.moveWarlordToEnd(armyWith_O_Or_One_Warlord);

        System.out.println(armyWith_O_Or_One_Warlord);
    }

    @Test
    void shouldCheckIfArmyIsValidated(){

//        System.out.println(armyWithoutWarlords);
//        System.out.println(armyWithOneWarlord);
        System.out.println(armyWith7Warlords);

        Character newArmyCharacter = armyWith7Warlords.getNextCharacter()
                .equipWithAccessory(new CharacterEquipmentService.Builder()
                        .addAccessory(Weapon.MAGIC_WAND)
                        .addAccessory(Weapon.MAGIC_WAND)
                        .build());

        System.out.println(newArmyCharacter);
    }
}
