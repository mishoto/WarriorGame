package edu.mihail.characters;

public class Defender extends Warrior {

    private static final int ATTACK = 3;
    private static final int DEFENCE = 2;

    @Override
    public int getHealth() {
        return 60;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getDefence(){
        return DEFENCE;
    }
}
