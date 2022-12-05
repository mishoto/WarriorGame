package edu.mihail.services;

import edu.mihail.models.accessories.weapons.Weapon;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractEquipmentService {
    final Set<Weapon> accessories;

    abstract static class Builder<T extends  Builder<T>>{
        private final Set<Weapon> accessories = new HashSet<>();

        public T addAccessory(Weapon weapon){
            accessories.add(weapon);
            return self();
        }
        public T removeAccessory(Weapon weapon){
            accessories.remove(weapon);
            return self();
        }

        abstract AbstractEquipmentService build();

        protected abstract T self();
    }

    AbstractEquipmentService(Builder<?> builder){
        accessories = builder.accessories;
    }

    public Set<Weapon> getAccessories() {
        return accessories;
    }
}
