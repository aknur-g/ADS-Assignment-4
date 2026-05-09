import java.util.*;

// Graph class
// Represents a graph using adjacency list
public class Graph {

    // Adjacency list:
    // key = vertex
    // value = list of neighbors
    private Map<Integer, List<Integer>> adjacencyList;

    // Constructor
    // Creates empty adjacency list
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Adds a vertex to the graph
    public void addVertex(Vertex v) {

        // putIfAbsent adds vertex only if it does not exist
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    // Adds an edge from one vertex to another
    public void addEdge(int from, int to) {

        // Make sure both vertices exist
        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.putIfAbsent(to, new ArrayList<>());

        // Add destination vertex to neighbor list
        adjacencyList.get(from).add(to);

        // If you want UNDIRECTED graph,
        // uncomment the line below:

        // adjacencyList.get(to).add(from);
    }

    // Prints graph structure
    public void printGraph() {

        System.out.println("Graph structure:");

        // Loop through all vertices
        for (int vertex : adjacencyList.keySet()) {

            // Print current vertex
            System.out.print(vertex + " -> ");

            // Print all neighbors
            for (int neighbor : adjacencyList.get(vertex)) {

                System.out.print(neighbor + " ");
            }

            System.out.println();
        }
    }

    // Breadth-First Search (BFS)
    // Uses Queue
    public void bfs(int start) {

        // Stores visited vertices
        Set<Integer> visited = new HashSet<>();

        // Queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();

        // Mark starting vertex as visited
        visited.add(start);

        // Add start vertex to queue
        queue.add(start);

        System.out.println("BFS Traversal:");

        // Continue until queue becomes empty
        while (!queue.isEmpty()) {

            // Remove first vertex from queue
            int current = queue.poll();

            // Print current vertex
            System.out.print(current + " ");

            // Get neighbors of current vertex
            for (int neighbor : adjacencyList.get(current)) {

                // Visit only unvisited neighbors
                if (!visited.contains(neighbor)) {

                    // Mark as visited
                    visited.add(neighbor);

                    // Add neighbor to queue
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    // Depth-First Search (DFS)
    // Uses recursion
    public void dfs(int start) {

        // Stores visited vertices
        Set<Integer> visited = new HashSet<>();

        System.out.println("DFS Traversal:");

        // Start recursive DFS
        dfsHelper(start, visited);

        System.out.println();
    }

    // Recursive helper method for DFS
    private void dfsHelper(int current, Set<Integer> visited) {

        // Mark current vertex as visited
        visited.add(current);

        // Print current vertex
        System.out.print(current + " ");

        // Visit all neighbors
        for (int neighbor : adjacencyList.get(current)) {

            // Go deeper only if not visited
            if (!visited.contains(neighbor)) {

                // Recursive call
                dfsHelper(neighbor, visited);
            }
        }
    }
}
