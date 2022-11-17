package edu.mihail.characters;

public class Warrior {

    private static final int ATTACK = 5;
    private  int health;


    public Warrior() {
        setHealth(50);
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return ATTACK;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive(int health){
        return health > 0;
    }

    public void hit(Warrior warrior){
        warrior.health = warrior.getHealth() - this.getAttack();
    }
}
