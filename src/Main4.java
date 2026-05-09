public class Main4 {

    public static void main(String[] args) {

        Graph graph = new Graph();

        for (int i = 1; i <= 10; i++) {
            graph.addVertex(new Vertex(i));
        }

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 8);
        graph.addEdge(5, 9);
        graph.addEdge(6, 10);

        System.out.println("GRAPH:");
        graph.printGraph();

        System.out.println();

        Experiment4 experiment = new Experiment4();

        experiment.runTraversals(graph);

        experiment.runMultipleTests();

        experiment.printResults();
    }
}