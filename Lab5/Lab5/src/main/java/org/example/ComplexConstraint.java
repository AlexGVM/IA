package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexConstraint {

    public static void main(String[] args){
        //CSP es un conjunto de variables, dominio y restricciones
        List<String> variables = List.of("A","B","C","D","E","F","G","H","I","J"
                ,"K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","AA"); //se incluye a tasmania para la asignacion
        //Dominio
        //Es red,green y blue
        Map<String,List<String>> domains = new HashMap<>();
        for (var variable:variables){
            domains.put(variable, List.of("cyan", "magenta", "yellow","black"));
        }

        CSP<String,String> problema = new CSP<>(variables,domains);
        problema.addConstraint(new AustraliaColiringCostraint("A", "V"));
        problema.addConstraint(new AustraliaColiringCostraint("A", "B"));
        problema.addConstraint(new AustraliaColiringCostraint("B", "V"));
        problema.addConstraint(new AustraliaColiringCostraint("V", "H"));
        problema.addConstraint(new AustraliaColiringCostraint("V", "W"));
        problema.addConstraint(new AustraliaColiringCostraint("N", "J"));
        problema.addConstraint(new AustraliaColiringCostraint("J", "K"));
        problema.addConstraint(new AustraliaColiringCostraint("K", "O"));
        problema.addConstraint(new AustraliaColiringCostraint("K", "F"));
        problema.addConstraint(new AustraliaColiringCostraint("K", "G"));
        problema.addConstraint(new AustraliaColiringCostraint("F", "C"));
        problema.addConstraint(new AustraliaColiringCostraint("G", "D"));
        problema.addConstraint(new AustraliaColiringCostraint("C", "D"));
        problema.addConstraint(new AustraliaColiringCostraint("C", "H"));
        problema.addConstraint(new AustraliaColiringCostraint("D", "H"));
        problema.addConstraint(new AustraliaColiringCostraint("E", "I"));
        problema.addConstraint(new AustraliaColiringCostraint("I", "M"));
        problema.addConstraint(new AustraliaColiringCostraint("H", "M"));
        problema.addConstraint(new AustraliaColiringCostraint("M", "Q"));
        problema.addConstraint(new AustraliaColiringCostraint("Q", "L"));
        problema.addConstraint(new AustraliaColiringCostraint("L", "P"));
        problema.addConstraint(new AustraliaColiringCostraint("P", "S"));
        problema.addConstraint(new AustraliaColiringCostraint("P", "U"));
        problema.addConstraint(new AustraliaColiringCostraint("P", "T"));
        problema.addConstraint(new AustraliaColiringCostraint("U", "T"));
        problema.addConstraint(new AustraliaColiringCostraint("U", "AA"));
        problema.addConstraint(new AustraliaColiringCostraint("T", "AA"));
        problema.addConstraint(new AustraliaColiringCostraint("AA", "Z"));
        problema.addConstraint(new AustraliaColiringCostraint("T", "Z"));
        problema.addConstraint(new AustraliaColiringCostraint("S", "Z"));
        problema.addConstraint(new AustraliaColiringCostraint("S", "Y"));
        problema.addConstraint(new AustraliaColiringCostraint("S", "X"));
        problema.addConstraint(new AustraliaColiringCostraint("S", "R"));
        problema.addConstraint(new AustraliaColiringCostraint("Z", "Y"));
        problema.addConstraint(new AustraliaColiringCostraint("Y", "X"));
        problema.addConstraint(new AustraliaColiringCostraint("X", "R"));
        problema.addConstraint(new AustraliaColiringCostraint("X", "W"));
        problema.addConstraint(new AustraliaColiringCostraint("R", "W"));

        var solution = problema.backtrack();
        System.out.println(solution);
    }
}
