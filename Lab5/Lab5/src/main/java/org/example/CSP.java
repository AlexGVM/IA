package org.example;

import java.lang.invoke.ConstantCallSite;
import java.util.*;

public class CSP <V,D>{

    private List<V> variables;
    private Map<V,List<D>> domains;
    private Map<V,List<Constraint<V,D>>> constraints = new HashMap<>();
    private List<String> coloresMemory = new ArrayList<>();


    public CSP(List<V> variables, Map<V,List<D>>domains){
        this.variables =variables;
        this.domains = domains;

        for (V variable: variables){
              constraints.put(variable,new ArrayList<Constraint<V, D>>());
              //cada variable debe de tener un dominio asignado
            if (!domains.containsKey(variable)){ //si alguna variable no contiene un dominio, es error
                throw new IllegalArgumentException("La variable " +variable+ " no contiene un domonio");
            }

        }
    }
    public void addConstraint(Constraint<V,D> constraint){

        for (V variable: constraint.variables) { //obtiene el listado
            //variable que se encuentra en el constraint tambien sea parte del CSP

            if (!this.variables.contains(variable)){ //la variable existe o no
                throw new IllegalArgumentException("La variable " + variable + " no se encuentra en el CSP"); //para tirar mensaje de error
            }
            constraints.get(variable).add(constraint);  //constraint es para agregar uno solo
        }
    }
    public boolean consistent(V variable, Map<V,D> assigment){ //calcular la consistencia
        for (Constraint<V,D> constraint:this.constraints.get(variable)) {
            if (!constraint.satisfied(assigment)){
                return false; //es incorrecta
            }
        }
        return true;
    }


    public Map<V,D> backtrack(){ //arranca en vacio
        return backtrack(new HashMap<V, D>());
    }

    public Map<V,D> backtrack(Map<V,D> assigment){
        //condicion de escape =  si la aignacion es completa = si cada variable tiene un valor
        if (variables.size() == assigment.size()){
            return assigment;
        }
        //variable no asignada
        var unassigned = variables.stream() //filtrar las variables que aun no esten en assigment
                .filter(v -> !assigment.containsKey(v))
                .findFirst().get();

        for (D value:domains.get(unassigned)){

            System.out.println("Variable: " + unassigned + " valor: " + value);
            //1. crear una copia de la asignacion anterior para tener area de trabajo
            Map<V, D> localassigment = new HashMap<>(assigment); //copia
            //2. probar asignar un valor
            localassigment.put(unassigned, value);

            var dato = localassigment.values()
                    .stream().toArray(); //programacion funcional para obtener color respectivo.
            coloresMemory.add(dato[0].toString());

            //3. Verficar la consitencia de la asignacion
            if (consistent(unassigned, localassigment)) { //recursividad metodo booleano
                Map<V, D> result = backtrack(localassigment);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

}
