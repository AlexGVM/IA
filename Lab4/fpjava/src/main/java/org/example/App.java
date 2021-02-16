package org.example;

import org.example.functional.MyFunctionalInterface;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void doSomethingTraditional(){ //funcional
        var tux = new Tux();
        System.out.println(tux.doSomething("Holi"));
    }
    public static void doSomethingClassy(){ //clase anonima

        //Clase anonima : implementacion directa de una interfaz
        //duke mascota de java, tux mascota de linux
        var duke = new MyFunctionalInterface() {
            @Override
            public String doSomething(String param) {
                return "Hola soy duke y recibi " + param;
            }
        };
        System.out.println(duke.doSomething("una clase anonima"));

    }
    public static void doSomethingFuctional(){ //lambda
        MyFunctionalInterface clippy = (String param) -> {
            return "Hola soy clippy y recibi " + param;
        };
        MyFunctionalInterface wilbert = (p) ->  "Hola soy wilber y recibi " + p;
        doSomethingHighOrder(clippy);
        doSomethingHighOrder(wilbert);
        doSomethingHighOrder(x-> "Hola soy anonymus y recibi " + x );
        var pikachu = new Pikachu();
        doSomethingHighOrder(pikachu::Pika);
        doSomethingHighOrder(pikachu::impactrueno);//:: referenciar //codigo existente en otra clase

    }
    public static void doSomethingHighOrder(MyFunctionalInterface comportamiento){
        //Ejecuta el comportamiento
        var respuesta = comportamiento.doSomething(" Java 11 es genial");
        System.out.println(respuesta);
    }
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
