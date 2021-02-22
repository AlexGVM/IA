package org.example;

import java.util.List;
import java.util.Map;

public abstract class Constraint <V,D> { //variables,dominio //no se puede implementar directamente

    protected List<V> variables;
    public Constraint(List<V> variables){
        this.variables = variables;
    }
    public abstract boolean satisfied(Map<V,D> assigment);
}

