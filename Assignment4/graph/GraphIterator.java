package graph;

import java.util.Iterator;

public class GraphIterator implements Iterator{
    private int v; //current location
    private int V; // total vertex
    private int[][] IT;
    private int w = 0;

    GraphIterator(int[][] mat, int V, int v) {
        this.IT = mat;
        this.v = v;
        this.V = V;
    }


    public boolean hasNext() {
        while (w < V) {
            if (IT[v][w] == 1) return true;
            w++;
        }
        return false;
    }

    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return w++;
    }

}
