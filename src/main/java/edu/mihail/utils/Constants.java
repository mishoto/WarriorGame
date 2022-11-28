package edu.mihail.utils;

public final class Constants {

    private Constants() {
    }

    public static final class Warrior {
        private Warrior() {
        }

        public static final int ATTACK = 5;
        public static final int INITIAL_HEALTH = 50;
        public static final int DEFENCE = 0;
    }

    public static final class Knight {
        private Knight() {
        }

        public static final int ATTACK = 7;
        public static final int INITIAL_HEALTH = 50;
        public static final int DEFENCE = 0;
    }

    public static final class Defender {
        private Defender() {
        }

        public static final int ATTACK = 3;
        public static final int INITIAL_HEALTH = 60;
        public static final int DEFENCE = 2;
    }

    public static final class Vampire {
        private Vampire() {
        }

        public static final int ATTACK = 4;
        public static final int INITIAL_HEALTH = 40;
        public static final int VAMPIRISM = 50;
    }

    public static final class Lancer {
        private Lancer() {
        }

        public static final int ATTACK = 6;
        public static final int INITIAL_HEALTH = 50;

    }

    public static final class Healer {
        private Healer() {
        }
        public static final int INITIAL_HEALTH = 60;
        public static final int HEALTH_POINTS = 2;
    }

    public static final class Weapon {
        private Weapon(){}
        public static final int SWORD_HEALTH = 5;
        public static final int SWORD_ATTACK = 2;

        public static final int SHIELD_HEALTH = 20;
        public static final int SHIELD_ATTACK = -1;
        public static final int SHIELD_DEFENCE = 2;

        public static final int GREAT_AXE_HEALTH = -15;
        public static final int GREAT_AXE_ATTACK = 5;
        public static final int GREAT_AXE_DEFENCE = -2;
        public static final int GREAT_AXE_VAMPIRISM = 10;

        public static final int KATANA_HEALTH = -20;
        public static final int KATANA_ATTACK = 6;
        public static final int KATANA_DEFENCE = -5;
        public static final int KATANA_VAMPIRISM = 50;

        public static final int MAGIC_WAND_HEALTH = 30;
        public static final int MAGIC_WAND_ATTACK = 3;
        public static final int MAGIC_WAND_HEAL_POWER = 3;

    }
}
