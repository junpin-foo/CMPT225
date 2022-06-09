# Assignment4
Dense Graph
The class represents a graph in the adjacency matrix representation model. It has one constructor
that gets the number of vertices, and the number of vertices does not change.
You need to implement the following methods:
public DenseGraph(int n)
creates an empty graph on n nodes.
the "names" of the vertices are 0,1,..,n-1

public int[][] getAdjacencyMatrix()
returns the adjacency matrix representing the graph

public void addEdge(int i, int j)
adds the edge (i,j) to the graph

public void removeEdge(int i, int j)
removes the edge (i,j) from the graph

public boolean areAdjacent(int i, int j)
checks if (i,j) is an edge in the graph

public int degree(int i)
returns the degree of i

public Iterator<Integer> neighboursIterator(int i)
Returns an iterator that outputs the neighbors of i in the increasing order
Assumption: the graph is not modified during the use of the iterator
  
public int numberOfVertices()
Returns the number of vertices in the graph
  
public int numberOfEdges()
Returns the number of edges in the graph
  
public int distance(int i, int j)
Returns the distance between i and j in the graph
  
public static DenseGraph generateRandomGraph(int n, double p)
Generates a random graph on n vertices such that each edge appears in the graph
with probability p independently of all others.
You may use Math.random() to generate a random number between 0 and 1
