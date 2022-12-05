package edu.mihail.factories.character;

import edu.mihail.models.characters.*;
import edu.mihail.models.contracts.Character;
import edu.mihail.services.AbstractEquipmentService;
import edu.mihail.utils.WeaponUtils;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterFactory implements AbstractCharacterFactory<Character> {

    @Override
    public List<Character> createMany(CharacterType characterType, int quantity) {
        return Stream.generate(() -> createCharacterInstance(characterType))
                .limit(quantity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Character> createOne(CharacterType characterType) {
        return Stream.generate(() -> createCharacterInstance(characterType))
                .limit(1)
                .collect(Collectors.toList());
    }

    public List<Character> createArmyCharacter(CharacterType characterType, AbstractEquipmentService abstractEquipmentService) {
        Character character = createCharacterInstance(characterType);
        return Stream.generate(() -> WeaponUtils.createArmyCharacterWithWeaponBonuses(character, abstractEquipmentService))
                .limit(1)
                .collect(Collectors.toList());
    }

    private Character createCharacterInstance(CharacterType characterType) {
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
            case HEALER:
                return new Healer();
            case WARLORD:
                return new Warlord();
            default:
                throw new IllegalArgumentException("There is no such warrior type!");
        }
    }
}
