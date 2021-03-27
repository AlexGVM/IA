package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class CSPARC <V, D>{

    private List<V> variables;
    private Map<V, List<D>> domains;
    private Map<V,List<Constraint<V, D>>> constraints = new HashMap<>();

    public CSPARC(List<V> variables, Map<V, List<D>> domains){
        this.variables = variables;
        this.domains = domains;

        for (V variable: variables) {
            constraints.put(variable, new ArrayList<Constraint<V,D>>());
            //verficar que cada variable debe de tener un dominio asignado
            //cada variable debe de tener su dominio compatible que debe de ser discreto y finito
            // y segundo los constrains que afectan a las variables
            if (!domains.containsKey(variable)) {
                throw new IllegalArgumentException("La variable "+ variable+" no contiene un dominio");
            }
        }


    }

    public  void addConstraint(Constraint<V, D> constraint){
        for (V variable: constraint.variables) {
            //verficar que la variable que se encuentra en el constraint tambien sea parte del CSP

            if (!this.variables.contains(variable)){
                throw new IllegalArgumentException("La variable "+variable+" no se encuentra en el CSP");
            }
            constraints.get(variable).add(constraint);
        }
    }

    public boolean consistent(V variable, Map<V,D> assignment){
        for (Constraint<V, D> constraint:this.constraints.get(variable)) {
            if (!constraint.satisfied(assignment)){
                return false;
            }
        }
        return true;
    }
    public Map<V, List<D>>  AC3(V value,D domain ,Map<V, List<D>> domainsC){

        List<V> vecinos = new ArrayList<>();

        for (var vecinoaux: constraints.get(value)) {

            vecinos.add(vecinoaux.variables.stream()
                    .filter(x -> !x.equals(value))
                    .findFirst().get());
        }
        var domainnew = domainsC.get(value).stream()
                .filter(x->x.equals(domain))
                .collect(Collectors.toList());

        domainsC.replace(value,domainnew);
        for (var auxvecinos : vecinos) {
            var newdomain = domainsC.get(auxvecinos).stream()
                    .filter(x->!x.equals(domain))
                    .collect(Collectors.toList());

            domainsC.replace(auxvecinos,newdomain);
        }
        return domainsC;
    }

    public Map<V, D> backtrack(){
        return backtrack(new HashMap<>(),domains );
    }

    public Map<V,D> backtrack(Map<V, D> assigment,Map<V, List<D>> domains){

        if (variables.size() == assigment.size()){
            return assigment;
        }

        V unssigned = variables.stream()
                .filter(v -> !assigment.containsKey(v))
                .findFirst().get();

        for (D value:domains.get(unssigned)){

            System.out.println("Variable: " + unssigned+ " valor: "+value);
            Map<V, D> localAssigment = new HashMap<>(assigment);
            Map<V,List<D>> localDomains = new HashMap<>(domains);
            localAssigment.put(unssigned,value);

            if (consistent(unssigned,localAssigment)){
                var newDomins = AC3(unssigned,value,localDomains);
                Map<V, D> result = backtrack(localAssigment,newDomins);

                if (result != null || newDomins != null){
                    return  result;
                }
            }
        }
        return null;
    }











}
