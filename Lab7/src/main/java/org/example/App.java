package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var calculadora = new Calculadora();
        var resultado = calculadora.Sumar(5,5);
        System.out.println(resultado);
    }
}
