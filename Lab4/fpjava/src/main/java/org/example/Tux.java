package org.example;
import org.example.functional.MyFunctionalInterface;

public class Tux implements MyFunctionalInterface {

    @Override
    public String doSomething(String param) {
        return "Hola soy Tux y recibi el siguiente parametro " + param;
    }
}
