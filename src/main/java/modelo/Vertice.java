package modelo;

import java.util.LinkedList;

public class Vertice<E> {
double posicionx;
double posiciony;
private E content;
private LinkedList<Arista<E>> aristas;
public E getContent() {
    return content;
}
public LinkedList<Arista<E>> getAristas() {
    return aristas;
}
public Vertice(double posicionx, double posiciony) {
    this.posicionx = posicionx;
    this.posiciony = posiciony;
}
public double getPosicionx() {
    return posicionx;
}
public double getPosiciony() {
    return posiciony;
}

}
