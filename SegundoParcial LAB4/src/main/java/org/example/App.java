package org.example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App
{
     public void codeComment(){
        //Predicate<String> isNotAJedi = (s) -> !s.equals("Rey"); //predicado
        //jedis.removeIf(s -> s.equals("Rey")); //solo trabaja listas mutables
        //composicion de funciones // FP por el forEach
        //Stream API serie de intefaces funcionales predefinidas
        //Predicados es una interfaz funciona cualquier tipo de dato y retorna si es verdadero o falso
    }

    public static void main( String[] args )
    {

        List jedis = List.of("Anakin", "Leia", "Luke", "Rey");

        var filtered = jedis.stream()
                .filter(s -> !s.equals("Rey"))//Map
                .map(j -> j.toString().toUpperCase()) //Map
                .collect(Collectors.toList()); //Reduce
        var theJedi = jedis.stream()
                .filter(s -> !s.equals("Rey"))//Map
                .map(j -> j.toString().toUpperCase()) //Map
                .findFirst(); //Reduce

        System.out.println("Resultado de la stream API " + theJedi.get());
        System.out.println(filtered);

    }
}
