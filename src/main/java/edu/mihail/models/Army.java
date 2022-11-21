package edu.mihail.models;

import edu.mihail.factories.CharacterType;
import edu.mihail.factories.WarriorFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Army {

    protected List<List<Warrior>> troop;
    private final Iterator<List<Warrior>> troopIterator;

    public static class Builder {
        private final List<List<Warrior>> troop = new LinkedList<>();

        public Builder createTroopOf(CharacterType characterType, int quantity) {
            troop.add(new WarriorFactory().createMany(characterType, quantity));
            return this;
        }

        public Army build() {
            return new Army(this);
        }
    }

    private Army(Builder builder) {
        troop = builder.troop;
        troopIterator = troop.listIterator();
    }

    public Iterator<List<Warrior>> getTroopIterator() {
        return troopIterator;
    }

    public List<Warrior> getArmy(){
        return troop.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public Warrior getNextWarrior(){
        return !this.getArmy().isEmpty() ? this.getArmy().listIterator().next() : null;
    }

    @Override
    public String toString() {
        return "Army{" +
                "troop=" + troop +
                '}';
    }
}
