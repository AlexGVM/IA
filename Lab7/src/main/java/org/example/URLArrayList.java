package org.example;

import java.util.Arrays;
import java.util.Objects;

public class URLArrayList implements List {

    private Object[] elements;

    @Override
    public Object get(int a) throws IndexOutOfBoundsException {
        return elements[a]; //obtener el valor del objeto
    }
    @Override
    public boolean isEmpty() {
        return this.elements.length == 0;
    } // tamano es igual a 0

    @Override
    public int size() {
        return this.elements.length;
    } //tamano del elemento

    @Override
    public Object set(int a, Object O) throws IndexOutOfBoundsException {
        Object anterior = elements[a]; //busca el elemento deseado
        elements[a]=O;
        return anterior; //setear el valor de elements
    }

    @Override
    public void add(int a, Object O) throws IndexOutOfBoundsException {
        if (elements != null)
        {
            elements = Arrays.copyOf(elements,elements.length + 1);
            var temp = Arrays.copyOf(elements,elements.length + 1);

            elements[a]=O;

            for (int j=0;j<a;j++){
                elements[j]=temp[j];
            }

            for (int j= a+1;j<elements.length;j++){
                elements[j]=temp[j-1];
            }
        }
        else
        {
            elements = new Object[1];
            elements[0]=O;
        }

    }

    @Override
    public Object remove(int a) throws IndexOutOfBoundsException {
        Object old;

        if (elements.length != 1)
        {
            old=elements[a];

            var temp = Arrays.copyOf(elements,elements.length);

            elements = new Object[elements.length-1];

            for (int j=0;j<a;j++){

                elements[j]=temp[j];
            }

            for (int j=a;j<elements.length;j++){

                elements[j]=temp[j+1];
            }

        }
        else
        {
            old=elements[0];
            elements = new Object[0];
        }
        return old;
    }
}
