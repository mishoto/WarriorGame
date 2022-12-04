
package edu.mihail.models.accessories.weapons;

import edu.mihail.utils.Constants;

public enum Weapon {
    SWORD(
            Constants.Weapon.SWORD_HEALTH,
            Constants.Weapon.SWORD_ATTACK,
            Constants.Weapon.SWORD_DEFENCE,
            Constants.Weapon.SWORD_VAMPIRISM,
            Constants.Weapon.SWORD_HEAL_POWER
    ),
    SHIELD(
            Constants.Weapon.SHIELD_HEALTH,
            Constants.Weapon.SHIELD_ATTACK,
            Constants.Weapon.SHIELD_DEFENCE,
            Constants.Weapon.SHIELD_VAMPIRISM,
            Constants.Weapon.SHIELD_HEAL_POWER
    ),
    GREAT_AXE(
            Constants.Weapon.GREAT_AXE_HEALTH,
            Constants.Weapon.GREAT_AXE_ATTACK,
            Constants.Weapon.GREAT_AXE_DEFENCE,
            Constants.Weapon.GREAT_AXE_VAMPIRISM,
            Constants.Weapon.GREAT_AXE_HEAL_POWER
    ),
    KATANA(
            Constants.Weapon.KATANA_HEALTH,
            Constants.Weapon.KATANA_ATTACK,
            Constants.Weapon.KATANA_DEFENCE,
            Constants.Weapon.KATANA_VAMPIRISM,
            Constants.Weapon.KATANA_HEAL_POWER
    ),
    MAGIC_WAND(
            Constants.Weapon.MAGIC_WAND_HEALTH,
            Constants.Weapon.MAGIC_WAND_ATTACK,
            Constants.Weapon.MAGIC_WAND_DEFENCE,
            Constants.Weapon.MAGIC_WAND_VAMPIRISM,
            Constants.Weapon.MAGIC_WAND_HEAL_POWER
    );

    private final int weaponHealth;
    private final int weaponAttack;
    private final int weaponDefence;
    private final int weaponVampirism;
    private final int weaponHealPower;

    Weapon(int health, int attack, int defence, int vampirism, int healPower) {
        this.weaponHealth = health;
        this.weaponAttack = attack;
        this.weaponDefence = defence;
        this.weaponVampirism = vampirism;
        this.weaponHealPower = healPower;
    }

    public int getWeaponHealth() {
        return weaponHealth;
    }

    public int getWeaponAttack(){
        return weaponAttack;
    }

    public int getWeaponDefence(){
        return weaponDefence;
    }

    public int getWeaponVampirism(){
        return weaponVampirism;
    }

    public int getWeaponHealPower(){
        return weaponHealPower;
    }
}

