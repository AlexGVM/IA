package org.example.graph;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class BFSVersion2 {
    public static<T> Optional<Node<T>> search(T value, Node<T> start ){ //nodo a llenar, nodo inicial

        Queue<Node> queue = new ArrayDeque<>();//inicializar cola
        queue.add(start);// se agraga a la cola el inicial

        Node<T> currentNode = null; //creacion de variable currenteNode

        Node<T> father = null;

        Set<Node<T>> closed = new HashSet<>(); //memoria //una coleccion de nodos existentes

        while(!queue.isEmpty()){ //1-verificar si puede continuar

            currentNode = queue.remove();

            System.out.println("Visitando el nodo... " + currentNode.getValue()); //se convierte en string

            //2-verificar si se encuentra en la meta
            if(currentNode.getValue().equals(value)){
                return Optional.of(currentNode);
            }
            else{
                if (!closed.contains(currentNode)){ // existe o no en memoria (no repetir caminos.
                    closed.add(currentNode); // 3-espacio explorado
                    queue.addAll(currentNode.getNeighbors()); // sucesor // expande
                }
                queue.removeAll(closed);//elimina el recien visitado
            }

        }
        return Optional.empty();
    }

}
