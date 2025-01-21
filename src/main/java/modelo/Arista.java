package modelo;

public class Arista <E>{
    private Vertice<E> vertice;
    private Vertice<E> verticeDestino;
    private int peso;

    public Arista(Vertice<E> vertice, int peso) {
        this.vertice = vertice;
        this.peso = peso;
    }

    public Vertice<E> getVertice() {
        return vertice;
    }

    public void setVertice(Vertice<E> vertice) {
        this.vertice = vertice;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
