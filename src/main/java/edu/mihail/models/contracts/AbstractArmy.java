package edu.mihail.models.contracts;

import java.util.Collection;

public abstract class AbstractArmy<T> {

    protected Collection<T> characters;

    protected abstract Collection<T> getArmy();
}
