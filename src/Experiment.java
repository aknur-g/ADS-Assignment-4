public class Experiment {

    public void runTraversals(Graph g, int startVertex) {

        long startBFS = System.nanoTime();

        g.bfs(startVertex);

        long endBFS = System.nanoTime();

        long bfsTime = endBFS - startBFS;

        System.out.println("BFS Execution Time: " + bfsTime + " ns");

        long startDFS = System.nanoTime();

        g.dfs(startVertex);

        long endDFS = System.nanoTime();

        long dfsTime = endDFS - startDFS;

        System.out.println("DFS Execution Time: " + dfsTime + " ns");
    }

    public void runMultipleTests() {

        int[] sizes = {10, 30, 100};

        for (int size : sizes) {

            System.out.println("\n==============================");
            System.out.println("Testing Graph with " + size + " vertices");
            System.out.println("==============================");

            Graph graph = new Graph();

            for (int i = 0; i < size; i++) {

                graph.addVertex(new Vertex(i));
            }

            for (int i = 0; i < size - 1; i++) {

                graph.addEdge(i, i + 1);
            }

            if (size == 10) {

                graph.printGraph();
            }

            runTraversals(graph, 0);
        }
    }

    public void printResults() {

        System.out.println("\nExperiment completed successfully.");
    }
}
