package edu.mihail.fightscene;

public interface FightStrategy<T> {

    boolean fight(T opponentOne, T opponentTwo);
}
