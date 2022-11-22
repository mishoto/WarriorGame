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
}
