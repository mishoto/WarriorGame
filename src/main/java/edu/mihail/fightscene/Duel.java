package edu.mihail.fightscene;

import edu.mihail.characters.Knight;
import edu.mihail.characters.Warrior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Duel {

    public boolean fight(Warrior warriorOne, Warrior warriorTwo){

        while (warriorOne.isAlive(warriorOne.getHealth()) || warriorTwo.isAlive(warriorTwo.getHealth())){
            warriorOne.hitBy(warriorTwo);
            warriorTwo.hitBy(warriorOne);
        }
        return warriorOne.getHealth() == 0;
    }

    public boolean fight(Warrior warriorOne, Knight warriorTwo){

        while (warriorOne.isAlive(warriorOne.getHealth()) || warriorTwo.isAlive(warriorTwo.getHealth())){
            warriorOne.hitBy(warriorTwo);
            warriorTwo.hitBy(warriorOne);
        }
        return warriorOne.getHealth() == 0;
    }

    public Warrior chooseRandomWarriorForFirstHit(Warrior warriorOne, Warrior warriorTwo){
        List<Warrior> listOfWarriors = Arrays.asList(warriorOne, warriorTwo);
        return listOfWarriors.get(new Random().nextInt(listOfWarriors.size()));
    }
}
