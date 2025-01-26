package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Grafo {
private List<Vertice> vertices;
    private List<Arista> aristas;

    public Grafo() {
        vertices = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    public void addVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void addArista(Arista arista) {
        aristas.add(arista);
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Arista> getAristas() {
        return aristas;
    }
    public List<Vertice> dijkstra(Vertice inicio, Vertice fin) {
        Map<Vertice, Double> distancias = new HashMap<>();
        Map<Vertice, Vertice> previos = new HashMap<>();
        PriorityQueue<Vertice> cola = new PriorityQueue<>(Comparator.comparing(distancias::get));

        for (Vertice vertice : vertices) {
            distancias.put(vertice, Double.MAX_VALUE);
            previos.put(vertice, null);
        }
        distancias.put(inicio, 0.0);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Vertice actual = cola.poll();

            if (actual.equals(fin)) {
                break;
            }

            for (Object obj : actual.getAristas()) {
                Arista arista = (Arista) obj;
                Vertice vecino = arista.getVerticeDestino();
                double nuevaDistancia = distancias.get(actual) + arista.getPeso();

                if (nuevaDistancia < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDistancia);
                    previos.put(vecino, actual);
                    cola.add(vecino);
                }
            }
        }

        List<Vertice> camino = new ArrayList<>();
        for (Vertice at = fin; at != null; at = previos.get(at)) {
            camino.add(at);
        }
        Collections.reverse(camino);
        return camino;
    }

}