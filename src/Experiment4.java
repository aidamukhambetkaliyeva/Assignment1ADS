public class Experiment4 {

    public void runTraversals(Graph g) {

        System.out.println("BFS Traversal:");
        long bfsStart = System.nanoTime();

        g.bfs(1);

        long bfsEnd = System.nanoTime();

        System.out.println("BFS Time: " + (bfsEnd - bfsStart) + " ns");

        System.out.println();

        System.out.println("DFS Traversal:");
        long dfsStart = System.nanoTime();

        g.dfs(1);

        long dfsEnd = System.nanoTime();

        System.out.println("DFS Time: " + (dfsEnd - dfsStart) + " ns");

        System.out.println();
    }

    public Graph createGraph(int size) {
        Graph graph = new Graph();

        for (int i = 1; i <= size; i++) {
            graph.addVertex(new Vertex(i));
        }

        for (int i = 1; i < size; i++) {
            graph.addEdge(i, i + 1);
        }

        return graph;
    }

    public void runMultipleTests() {

        System.out.println("SMALL GRAPH");
        Graph small = createGraph(10);
        runTraversals(small);

        System.out.println("MEDIUM GRAPH");
        Graph medium = createGraph(30);
        runTraversals(medium);

        System.out.println("LARGE GRAPH");
        Graph large = createGraph(100);
        runTraversals(large);
    }

    public void printResults() {
        System.out.println("Experiments completed.");
    }
}