package edu.mihail.services;


public class CharacterEquipmentService extends AbstractEquipmentService{


    public static class Builder extends AbstractEquipmentService.Builder<Builder>{

        @Override
        public AbstractEquipmentService build() {
            return new CharacterEquipmentService(this) {
            };
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    CharacterEquipmentService(AbstractEquipmentService.Builder<?> builder) {
        super(builder);
    }

}
