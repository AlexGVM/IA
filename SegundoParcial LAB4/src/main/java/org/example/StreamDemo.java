package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    public static List<Integer> createRandomList(int qty){

        var random = new Random();
        List<Integer> numbers = new LinkedList<>(); //se recorrera secuencialemente

        for (int i = 0; i < qty; i++){
            numbers.add(random.nextInt(100)); //solo numero de 0-100
        }
        return numbers;
    }

    public static List<Integer> sortList(List<Integer> unsortedList){

        Collections.sort(unsortedList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return unsortedList;
    }
    public void commented(){

         /*var primo = IntStream.range(0,100).boxed()
                .filter(n -> isPrimeNumber(n))
                .collect(Collectors.toList());

        var listadodeprimos = createRandomList(Integer.valueOf(args[0])).stream() //serial
                .filter(n -> isPrimeNumber(n))
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Finaliza calculo");
        System.out.println(listadodeprimos);

        var primo = IntStream.range(0,100).boxed()
                .filter(n -> isPrimeNumber(n))
                .collect(Collectors.toList()); //0-100 // boxed compatible con un listado

        System.out.println(primo);

        var randomNumber = CreateRandomList(10);
        System.out.println(randomNumber);
        sortLambda(randomNumber);
        System.out.println(randomNumber);*/

    }
    public static List<Integer> fibonacci(int qty){
        int a = 0,b=1;
        int c;
        List<Integer> numlistF = new ArrayList<>();
        for (int i = 0; i < qty; i++){
            numlistF.add(a);
            c = a + b;
            a = b;
            b = c;
        }
        return numlistF;
    }
    public static boolean isPrimeNumber(int n){
        if (n <= 1) // es menor a 1 no puede ser primo
            return false;
        var contador = 0;
        for (int i = n-1; i > 1; i--) {
            if (n % i == 0) // si el residuo es igual a 0 quiere decir que existe un denominador en el cual se pueda dividir
                contador++;
        }
        return contador <= 0;
    }
    public static void main(String args[]){

        System.out.println("Sucesión Fibonacci");
        var fibonacciList = fibonacci(10);
        System.out.println(fibonacciList);
        System.out.println("---------------------------------------");

        System.out.println("Iniciando calculo de numeros primos");
        var dataPrime = createRandomList(100).parallelStream()
                .filter(n -> isPrimeNumber(n))
                .sorted()
                .map(j -> j.intValue()) //aun no entiendo muy bien
                .collect(Collectors.toList());

        var dataPrimeNotRepited = createRandomList(100).stream()
                .filter(n -> isPrimeNumber(n))
                .sorted()
                .map(j -> j.intValue()).distinct()
                .collect(Collectors.toList()); //recolecta en una lista

        System.out.println("Finaliza calculo de numeros primos");
        System.out.println(dataPrime);

    }
}
