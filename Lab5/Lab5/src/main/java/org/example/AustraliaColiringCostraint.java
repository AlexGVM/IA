package org.example;

import java.util.List;
import java.util.Map;

public class AustraliaColiringCostraint extends Constraint<String,String> {

    private String place1,place2;
    public AustraliaColiringCostraint(String place1,String place2){
        super(List.of(place1,place2));
        this.place1 =place1;
        this.place2 =place2;
    }

    @Override
    public boolean satisfied(Map<String, String> assigment) {
        //Chekear que lugar 1 <> lugar 2
        //variable no se encuentre aun asignada
        if (!assigment.containsKey(place1) || !assigment.containsKey(place2)){
            return true; // es consistente
        }
        return !assigment.get(place1).equals(assigment.get(place2)); //no son iguales
    }
}