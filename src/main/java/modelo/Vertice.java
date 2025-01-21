package modelo;

import java.util.LinkedList;

public class Vertice<E> {
private E content;
private LinkedList<Arista<E>> aristas;
public E getContent() {
    return content;
}
public LinkedList<Arista<E>> getAristas() {
    return aristas;
}

}
