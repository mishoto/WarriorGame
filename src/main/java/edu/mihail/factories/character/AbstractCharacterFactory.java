package edu.mihail.factories.character;

import java.util.List;

public interface AbstractCharacterFactory<T> {

    List<T> createMany(CharacterType characterType, int quantity);
    List<T> createOne(CharacterType characterType);
}
