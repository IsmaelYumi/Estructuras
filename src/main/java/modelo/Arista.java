package modelo;

public class Arista {
    private Vertice vertice;
    private Vertice verticeDestino;
    private int peso;

    public Arista(Vertice vertice, Vertice Vertice_destino, int peso) {
        this.vertice = vertice;
        this.peso = peso;
        this.verticeDestino = Vertice_destino;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public void setVertice(Vertice vertice) {
        this.vertice = vertice;
    }

    public int getPeso() {
        return peso;
    }

    public Vertice getVerticeDestino() {
        return verticeDestino;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
