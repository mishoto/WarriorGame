package edu.mihail.fightscene;

import edu.mihail.characters.Knight;
import edu.mihail.characters.Warrior;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Duel {

    public static boolean fight(Warrior warriorOne, Warrior warriorTwo){

        while (warriorOne.isAlive(warriorOne.getHealth()) && warriorTwo.isAlive(warriorTwo.getHealth())){
            warriorOne.hit(warriorTwo);
            if (warriorTwo.getHealth() < 0){
                break;
            }
            warriorTwo.hit(warriorOne);

        }
        return warriorOne.isAlive(warriorOne.getHealth());
    }

    public Warrior chooseRandomFighterForFirstHit(Warrior warrior, Knight knight){
        List<Warrior> listOfWarriors = Arrays.asList(warrior, knight);
        return listOfWarriors.get(new Random().nextInt(listOfWarriors.size()));
    }
}
