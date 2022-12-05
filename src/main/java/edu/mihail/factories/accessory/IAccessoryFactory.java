package edu.mihail.factories.accessory;


public interface IAccessoryFactory<T> {

    T createAccessory(T t);
}
