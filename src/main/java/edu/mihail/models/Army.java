package edu.mihail.models;

import edu.mihail.factories.CharacterType;
import edu.mihail.factories.WarriorFactory;

import java.util.ArrayList;
import java.util.List;


public class Army {

    protected List<List<Warrior>> troop;

    public static class Builder {
        private final List<List<Warrior>> troop = new ArrayList<>();

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
    }

    @Override
    public String toString() {
        return "Army{" +
                "troop=" + troop +
                '}';
    }
}
