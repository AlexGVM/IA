package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class URLArrayListTest {

    URLArrayList list;

    @BeforeEach
    public void Inicial(){
        list = new URLArrayList();
    }

    @Test
    @DisplayName("Test List")
    public void PruebaLista(){

        list.add(0,10);
        list.add(0,9);
        list.add(0,8);
        list.add(0,7);
        list.add(0,6);
        list.add(0,5);

        assertEquals(5,list.get(0));
        assertEquals(8,list.get(3));

        list.add(0,40);
        list.set(0,4);

        assertEquals(4,list.get(0));
        assertEquals(8,list.get(4));

        assertTrue(!list.isEmpty());

        assertEquals(7,list.size());

        assertEquals(5,list.set(1,50));
        assertEquals(7,list.remove(3));


    }
}
