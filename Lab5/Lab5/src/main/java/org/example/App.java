package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //CSP es un conjunto de variables, dominio y restricciones
        List<String> variables = List.of("Western Australia","Northern Territory",
                "Queensland","South Australia","New South Wales","Victoria","Tasmania"); //se incluye a tasmania para la asignacion
        //Dominio
        //Es red,green y blue
        Map<String,List<String>> domains = new HashMap<>();
        for (var variable:variables){
            domains.put(variable, List.of("rojo", "verde", "azul"));
        }

        CSP<String,String> problema = new CSP<>(variables,domains);
        problema.addConstraint(new AustraliaColiringCostraint("Western Australia", "Northern Territory"));
        problema.addConstraint(new AustraliaColiringCostraint("Western Australia", "South Australia"));
        problema.addConstraint(new AustraliaColiringCostraint("South Australia", "Northern Territory"));
        problema.addConstraint(new AustraliaColiringCostraint("Queensland", "Northern Territory"));
        problema.addConstraint(new AustraliaColiringCostraint("Queensland", "South Australia"));
        problema.addConstraint(new AustraliaColiringCostraint("New South Wales","Queensland"));
        problema.addConstraint(new AustraliaColiringCostraint("New South Wales", "South Australia"));
        problema.addConstraint(new AustraliaColiringCostraint("Victoria", "South Australia"));
        problema.addConstraint(new AustraliaColiringCostraint("New South Wales", "Victoria"));
        problema.addConstraint(new AustraliaColiringCostraint("Tasmania", "Victoria"));

        var solution = problema.backtrack();
        System.out.println(solution);
    }
}
