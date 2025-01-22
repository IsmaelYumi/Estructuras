package modelo;

import java.util.LinkedList;

public class Grafo<E> {
private LinkedList<Vertice<E>> vertices=new LinkedList<>();
public LinkedList<Vertice<E>> getVertices() {
    return vertices;
}
public void setVertices(LinkedList<Vertice<E>> vertices) {
    this.vertices = vertices;
}
public void addVertice(Vertice<E> vertice) {
    this.vertices.add(vertice);
}
}