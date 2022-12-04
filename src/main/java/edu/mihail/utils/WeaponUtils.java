package edu.mihail.utils;

import edu.mihail.factories.character.CharacterType;
import edu.mihail.models.accessories.weapons.Weapon;
import edu.mihail.models.characters.*;
import edu.mihail.models.contracts.Character;
import edu.mihail.services.AbstractEquipmentService;

import java.util.*;

public final class WeaponUtils {

    private WeaponUtils(){};

    public static List<Integer> calculateWeaponBagBonuses (AbstractEquipmentService abstractEquipmentService){
        Set<Weapon> weaponBag = new HashSet<>(abstractEquipmentService.getAccessories());
        List<Integer> list = new ArrayList<>();

        list.add(weaponBag.stream().mapToInt(Weapon::getWeaponHealth).sum());
        list.add(weaponBag.stream().mapToInt(Weapon::getWeaponAttack).sum());
        list.add(weaponBag.stream().mapToInt(Weapon::getWeaponDefence).sum());
        list.add(weaponBag.stream().mapToInt(Weapon::getWeaponVampirism).sum());
        list.add(weaponBag.stream().mapToInt(Weapon::getWeaponHealPower).sum());

        return list;
    }

    public static Character createArmyCharacterWithWeaponBonuses(Character character, AbstractEquipmentService abstractEquipmentService){
        CharacterType characterType = CharacterUtils.getTypeFromCharacterInstance(character);
        List<Integer> listWithBonuses = calculateWeaponBagBonuses(abstractEquipmentService);
        switch (characterType){
            case HEALER: {
                Healer healer = (Healer) character;
                int health = Math.max(healer.getHealth() + listWithBonuses.get(0), 0);
                validateHealth(health);
                int healthPoints = Math.max(healer.getHealthPoints() + listWithBonuses.get(4), 0);

                return new ArmyCharacter(characterType, health, 0, 0, 0, healthPoints);
            }
            case WARRIOR:
            {
                Warrior warrior = (Warrior) character;
                int health = Math.max(warrior.getHealth() + listWithBonuses.get(0), 0);
                validateHealth(health);
                int attack = Math.max(warrior.getAttack() + listWithBonuses.get(1), 0);
                return new ArmyCharacter(characterType, health, attack, 0, 0, 0);
            }
            case KNIGHT:
            {
                Knight knight = (Knight) character;
                int health = Math.max(knight.getHealth() + listWithBonuses.get(0), 0);
                validateHealth(health);
                int attack = Math.max(knight.getAttack() + listWithBonuses.get(1), 0);
                return new ArmyCharacter(characterType, health, attack, 0, 0, 0);
            }
            case DEFENDER:
            {
                Defender defender = (Defender) character;
                int health = Math.max(defender.getHealth() + listWithBonuses.get(0), 0);
                validateHealth(health);
                int attack = Math.max(defender.getAttack() + listWithBonuses.get(1), 0);
                int defence = Math.max(defender.getDefence() + listWithBonuses.get(2), 0);
                return new ArmyCharacter(characterType, health, attack, defence, 0, 0);
            }
            case VAMPIRE:
            {
                Vampire vampire = (Vampire) character;
                int health = Math.max(vampire.getHealth() + listWithBonuses.get(0), 0);
                validateHealth(health);
                int attack = Math.max(vampire.getAttack() + listWithBonuses.get(1), 0);
                int vampirism = Math.max(vampire.getVampirism() + listWithBonuses.get(3), 0);
                return new ArmyCharacter(characterType, health, attack, 0, vampirism, 0);
            }
            case LANCER:
            {
                Lancer lancer = (Lancer) character;
                int health = Math.max(lancer.getHealth() + listWithBonuses.get(0), 0);
                validateHealth(health);
                int attack = Math.max(lancer.getAttack() + listWithBonuses.get(1), 0);
                return new ArmyCharacter(characterType, health, attack, 0, 0, 0);
            }
            case WARLORD:
            {
                Warlord warlord = (Warlord) character;
                int health = Math.max(warlord.getHealth() + listWithBonuses.get(0), 0);
                validateHealth(health);
                int attack = Math.max(warlord.getAttack() + listWithBonuses.get(1), 0);
                int defence = Math.max(warlord.getDefence() + listWithBonuses.get(2), 0);
                return new ArmyCharacter(characterType, health, attack, defence, 0, 0);
            }
            default: throw new IllegalArgumentException("No such warrior type");
        }
    }

    private static void validateHealth(int health) {
        if(health == 0){
            throw new IllegalArgumentException("Hey your health is 0, please remove any weapon");
        }
    }
}
