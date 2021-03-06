/*File: Grafo.java
 *Esta clase representa un grafo dirigido de NumVertices, la
 *implementación fue realizada mediante matrices de adyacencia*/


import java.util.Arrays;

public class Grafo {
    private final int NUM_VERTICES;
    private final int[][] grafo;

    //Crea un grafo de numVertices
    //La matriz de adyacencia es inicializada con ceros.
    public Grafo(int numVertices) {
        this.NUM_VERTICES = numVertices;
        grafo = new int[NUM_VERTICES][NUM_VERTICES];

        for (int[] ints : grafo) Arrays.fill(ints, 0);
    }

    public void insertarArista(int v1, int v2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        this.grafo[v1][v2] = 1;
        this.grafo[v2][v1] = 1;
    }

    public boolean existeArista(int v1, int v2) throws ArrayIndexOutOfBoundsException {

        return (grafo[v1][v2] != 0);
    }

    public void eliminarArista(int v1, int v2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (grafo[v1][v2] == 0) throw new IllegalArgumentException("La arista No existe");
        grafo[v1][v2] = 0;
        grafo[v2][v1] = 0;
    }

    public void liberarGrafo() {
        for (int[] ints : grafo) {
            Arrays.fill(ints, 0);
        }
    }

    public void imprimirGrafo() {
        System.out.printf("  %d", 0);
        for (int i = 1; i < grafo.length; i++) {
            System.out.printf(" %d", i);
        }
        System.out.println();

        for (int i = 0; i < grafo.length; i++) {
            System.out.printf("%d ", i);
            for (int j = 0; j < grafo[i].length; j++) {
                System.out.printf("%d ", grafo[i][j]);
            }
            System.out.println();
        }
    }

// ----- Métodos para Mostrar la lista de adyacencia de un vértice -----//

    public boolean tieneAdyacentes(int v) throws ArrayIndexOutOfBoundsException {
        int vActual = 0;
        boolean existeLista = false;

        while (vActual < this.NUM_VERTICES && !existeLista) {
            if (grafo[v][vActual] != 0) {
                existeLista = true;
            } else {
                vActual = vActual + 1;
            }
        }

        return existeLista;
    }


    public int obtenerPrimerAdy(int v) throws ArrayIndexOutOfBoundsException, UnsupportedOperationException {
        int adyacente = -1;
        int vActual = 0;
        boolean existeLista = false;

        while (vActual < this.NUM_VERTICES && !existeLista) {
            if (grafo[v][vActual] == 0) {
                vActual = vActual + 1;
            } else {
                adyacente = vActual;
                existeLista = true;
            }
        }

        if (!existeLista) throw new UnsupportedOperationException("No existe Lista");

        return adyacente;
    }

    public int sgteAdyacente(int v, int anteriorAd) throws ArrayIndexOutOfBoundsException, UnsupportedOperationException {
        int adyacente = 0;
        int vActual = anteriorAd + 1;
        boolean existeLista = false;

        while (vActual < this.NUM_VERTICES && !existeLista) {
            if (grafo[v][vActual] == 0) {
                vActual = vActual + 1;
            } else {
                adyacente = vActual;
                existeLista = true;
            }
        }

        if (!existeLista) adyacente = -1;
        return adyacente;
    }
// ----- Fin de métodos para mostrar lista de adyacencia de un vértice -----//	
}
