package edu.mihail.fightscene;

import edu.mihail.characters.Knight;
import edu.mihail.characters.Warrior;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Duel {

    private Warrior warrior;
    private Knight knight;

    public Duel(Warrior warrior, Knight knight) {
        this.warrior = warrior;
        this.knight = knight;
    }

    public boolean fight(Warrior warrior, Knight knight){

        while (warrior.isAlive(warrior.getHealth()) || knight.isAlive(knight.getHealth())){
            warrior.hitByKnight(knight);
            knight.hitByWarrior(warrior);
        }
        return warrior.getHealth() == 0;
    }

    public Warrior chooseRandomFighterForFirstHit(Warrior warrior, Knight knight){
        List<Warrior> listOfWarriors = Arrays.asList(warrior, knight);
        return listOfWarriors.get(new Random().nextInt(listOfWarriors.size()));
    }
}
