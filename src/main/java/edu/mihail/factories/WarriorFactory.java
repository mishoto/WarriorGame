package edu.mihail.factories;

import edu.mihail.models.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WarriorFactory implements CharacterFactory<Warrior> {

    @Override
    public List<Warrior> createMany(CharacterType characterType, int quantity) {
        return Stream.generate(() -> createWarriorInstance(characterType).clone())
                .limit(quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Warrior createOne(CharacterType characterType) {
        return createWarriorInstance(characterType);
    }

    private Warrior createWarriorInstance(CharacterType characterType) {
        switch (characterType) {
            case WARRIOR:
                return new Warrior();
            case KNIGHT:
                return new Knight();
            case DEFENDER:
                return new Defender();
            case VAMPIRE:
                return new Vampire();
            case LANCER:
                return new Lancer();
            default:
                throw new IllegalArgumentException("There is no such warrior type!");
        }
    }
}
