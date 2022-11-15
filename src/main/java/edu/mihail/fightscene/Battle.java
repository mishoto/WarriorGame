package edu.mihail.fightscene;


import edu.mihail.characters.Army;

public class Battle implements Actions<Army> {


    @Override
    public boolean fight(Army a, Army b) {
        return false;
    }
}
