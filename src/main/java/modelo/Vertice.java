package modelo;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

public class Vertice<E> {
double posicionx;
double posiciony;
private E content;
private LinkedList<Arista> aristas=new LinkedList<>();
public E getContent() {
    return content;
}
public LinkedList<Arista> getAristas() {
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
public int distancia(Vertice otro) {
    Random random = new Random();
    int randomNumber = random.nextInt(10) + 1;
    return randomNumber;
}
@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return posicionx == vertice.posicionx && posiciony == vertice.posiciony;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicionx, posiciony);
    }

}
