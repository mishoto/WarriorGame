package edu.mihail.factories;


import java.util.List;

public interface CharacterFactory<T> {

    List<T> createMany(CharacterType characterType, int quantity);

    T createOne(CharacterType characterType);
}
