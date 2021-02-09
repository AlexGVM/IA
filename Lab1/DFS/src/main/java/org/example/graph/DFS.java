package org.example.graph;
import org.example.App;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;
import java.util.Set;

public class DFS {
    public static<T> Optional<Node<T>> search(T value, Node<T> start ){ //nodo a llenar, nodo inicial

        Stack<Node> stack = new Stack<>();
        stack.add(start);

        Node<T> currentNode = null; //creacion de variable currenteNode

        Set<Node<T>> closed = new HashSet<>(); //memoria //una coleccion de nodos existentes

        while(!stack.isEmpty()){ //1-verificar si puede continuar

            currentNode = stack.pop();
            System.out.println("Visitando el nodo... " + currentNode.getValue()); //se convierte en string
            //2-verificar si se encuentra en la meta
            if(currentNode.getValue().equals(value)){
                return Optional.of(currentNode);
            }
            else{

                if (!closed.contains(currentNode)){ // existe o no en memoria (no repetir caminos.
                    closed.add(currentNode); // 3-espacio explorado
                    //DFS
                    stack.addAll(currentNode.getNeighbors());// sucesor
                }
                stack.removeAll(closed);

            }

        }

        return Optional.empty();
    }

}
