package edu.mihail.models.weapons;

import edu.mihail.utils.Constants;

public enum Weapon {
    SWORD(
            Constants.Weapon.SWORD_HEALTH,
            Constants.Weapon.SWORD_ATTACK
    ),
    SHIELD(
            Constants.Weapon.SHIELD_HEALTH,
            Constants.Weapon.SHIELD_ATTACK,
            Constants.Weapon.SHIELD_DEFENCE
    ),
    GREAT_AXE(
            Constants.Weapon.GREAT_AXE_HEALTH,
            Constants.Weapon.GREAT_AXE_ATTACK,
            Constants.Weapon.GREAT_AXE_DEFENCE,
            Constants.Weapon.GREAT_AXE_VAMPIRISM
    ),
    KATANA(
            Constants.Weapon.KATANA_HEALTH,
            Constants.Weapon.KATANA_ATTACK,
            Constants.Weapon.KATANA_DEFENCE,
            Constants.Weapon.KATANA_VAMPIRISM
    ),
    MAGIC_WAND(
            Constants.Weapon.MAGIC_WAND_HEALTH,
            Constants.Weapon.MAGIC_WAND_ATTACK,
            Constants.Weapon.MAGIC_WAND_HEAL_POWER
    );

    private final int weaponHealth;
    private final int weaponAttack;
    private final int defence;
    private final int vampirism;
    private final int healPower;

    Weapon(Integer health, Integer attack, Integer... args) {
        this.weaponHealth = health;
        this.weaponAttack = attack;
        this.defence = args[0];
        this.vampirism = args[1];
        this.healPower = args[2];

    }

    public int weaponHealth() {
        return weaponHealth;
    }

    public int weaponAttack(){
        return weaponAttack;
    }

    public int weaponDefence(){
        return defence;
    }

    public int weaponVampirism(){
        return vampirism;
    }

    public int weaponHealPower(){
        return healPower;
    }
}

//Sword - health +5, attack +2
//        Shield - health +20, attack -1, defense +2
//        GreatAxe - health -15, attack +5, defense -2, vampirism +10%
//        Katana - health -20, attack +6, defense -5, vampirism +50%
//        MagicWand - health +30, attack +3, healPower +3

