package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculadoraTest {

    Calculadora calculadora;
    @BeforeEach
    public void init(){
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Prueba de Suma simple")
    public void ProbarSuma(){
        //Comparar esperado vs obtenido
        assertEquals(25,calculadora.Sumar(5,20)); //comparar esperado versus obtenido
    }
    @Test
    //@Disabled("El test de resta fue deshabilitado porque asi lo quiso el jefe XD")
    public void ProbarResta(){
        //Comparar esperado vs obtenido
        assertEquals(30,calculadora.Restar(50,20)); //comparar esperado versus obtenido
    }
    @Test
    public void ProbarMultiplicacion(){
        //Comparar esperado vs obtenido
        assertEquals(25,calculadora.Multiplicar(5,5)); //comparar esperado versus obtenido
    }
    @Test
    public void ProbarDivision(){
        assertThrows(ArithmeticException.class, () -> {
            var division = 100/0;
        });
    }
    @Test
    @DisplayName("Preuba de la tabla del 5")
    public void ProbarTabla5(){
        int[] numbers = {1,2,3,4,5};
        assertAll("Tabla del 5",
        ()->{assertEquals(5,calculadora.Multiplicar(5,1));},
        ()->{assertEquals(10,calculadora.Multiplicar(5,2));},
        ()->{assertEquals(15,calculadora.Multiplicar(5,3));},
        ()->{assertEquals(20,calculadora.Multiplicar(5,4));},
        ()->{assertEquals(25,calculadora.Multiplicar(5,5));}
        );
    }

     /*   @AfterEach
    public void shutdown(){
        System.out.println("Finalizando test ----------");
    }
    @AfterAll
    public static void destroy(){
        System.out.println("Finalizacion global ----------");
    }*/

}
