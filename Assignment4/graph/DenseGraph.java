package graph;

import java.util.Iterator;
import java.lang.Math;
import java.util.LinkedList;

public class DenseGraph {

	private int[][] mat;
	private int V;
	/**
	 * creates an empty graph on n nodes
	 * the "names" of the vertices are 0,1,..,n-1 
	 * @param n - number of vertices in the graph
	 */
	public DenseGraph(int n) {
		if (n < 0) throw new IllegalArgumentException("invalid # of vertices");
		this.V = n;
		this.mat = new int[n][n];
	}
	/**
	 * @return the adjacency matrix representing the graph
	 */
	public int[][] getAdjacencyMatrix() {
		return mat;
	}

	/**
	 * adds the edge (i,j) to the graph  
	 * no effect if i and j were already adjacent

	 * @param i, j - vertices in the graph
	 */
	public boolean contains(int v, int w) throws Exception{
		if(v >= V || v < 0 || w >= V || w < 0){
			throw new IllegalArgumentException("invalid index");
		}
		if (mat[v][w] == 1)
			return true;
		else
			return false;
	}

	public void addEdge(int i, int j) {

		if(i >= V || i < 0 || j >= V || j < 0){
			throw new IllegalArgumentException("invalid index");
		}

		if(mat[i][j] == 0){
			mat[i][j] = 1;
			mat[j][i] = 1;
		}
		return;
	}

	/**
	 * removes the edge (i,j) from the graph
	 * no effect if i and j were not adjacent
	 * @param i, j - vertices in the graph
	 */
	public void removeEdge(int i, int j) {

		if(i >= V || i < 0 || j >= V || j < 0){
			throw new IllegalArgumentException("invalid index");
		}

		if(mat[i][j] == 1){
			mat[i][j] = 0;
			mat[j][i] = 0;
		}
		return;
	}

	/**
	 * @param i, j - vertices in the graph
	 * @return true if (i,j) is an edge in the graph, and false otherwise
	 */
	public boolean areAdjacent(int i, int j) {

		if(i >= V || i < 0 || j >= V || j < 0){
			throw new IllegalArgumentException("invalid index");
		}

		if(mat[i][j] == 1)
			return true;

		return false;
	}

	/**
	 * @param i - a vertex in the graph
	 * @return the degree of i
	 */
	public int degree(int i) {
		if(i >= V || i < 0){
			throw new IllegalArgumentException("invalid index");
		}

		int counter = 0;
		for(int j = 0; j < V; j++){
			if(mat[i][j] == 1)
				counter++;
		}
		return counter;
	}
	
	/**
	 * The iterator must output the neighbors of i in the increasing order
	 * Assumption: the graph is not modified during the use of the iterator 
	 * @param i - a vertex in the graph
	 * @return an iterator that returns the neighbors of i
	 */
	public Iterator<Integer> neighboursIterator(int i) {

		if(i >= V || i < 0){
			throw new IllegalArgumentException("invalid index");
		}

		GraphIterator it = new GraphIterator(mat, V , i);

		return it;
	}

	/**
	 * @return number of vertices in the graph
	 */
	public int numberOfVertices() {
		return this.V;
	}

	/**
	 * @return number of edges in the graph
	 */
	public int numberOfEdges() { // formula = sum of all degree of V = 2(# of edges) macm201

		int totalDegV = 0;
		for(int i = 0; i < V; i++){
			totalDegV += degree(i);
		}
		return totalDegV/2;

	}

	/**
	 * @param i, j - vertices in the graph
	 * @return distance between i and j in the graph
	 */
	public int distance(int i, int j) {
		if(i >= V || i < 0 || j >= V || j < 0){
			throw new IllegalArgumentException("invalid index");
		}

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(i);

		int[]distances = new int[V];
		for(int k = 0; k < V; k++){
			distances[k] = -1; // all not visited
		}
		distances[i] = 0;

		while(!queue.isEmpty()){
			int current = queue.poll();
			for(int l = 0; l < V; l++){
				if(areAdjacent(current,l)){
					if(distances[l] == -1) { // not visited
						distances[l] = distances[current] + 1;
						queue.add(l);
					}
				}
			}
		}
		return distances[j];
	}

	/**
	 * @param n - number of vertices
	 * @param p - number between 0 and 1
	 * @return a random graph on n vertices, where each edge is added to the graph with probability p
	 */
	public static DenseGraph generateRandomGraph(int n, double p) {

		if(n < 0 || p < 0){
			throw new IllegalArgumentException("invalid argument");
		}

		DenseGraph ret = new DenseGraph(n);
		for(int i =0; i < n; i++){
			for(int j =i +1; j < n; j++) {

				int get = (Math.random() < p) ? 1 : 0;

				ret.mat[i][j] = get;
				ret.mat[j][i] = get;
			}
		}
		return ret;
	}
}
