import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAdjList {
    public static void main(String[] args) {
        List<List<Neighbour>> graph = createAdjListGraph();
        // get the number of nodes or vertices in graph
        int numNodes = graph.size();

        // print shortest distances
        for (int sourceNodeIndex = 0; sourceNodeIndex < numNodes; sourceNodeIndex++){
            // call dijkstra method
            int[] distances = dijkstra(graph, sourceNodeIndex);
            // print out values
            System.out.println(String.format("%n%-10s%-10s%-10s", "source", "target", "distance"));
            for (int targetNodeIndex = 0; targetNodeIndex < numNodes; targetNodeIndex++) {
                System.out.println(String.format("%-10s%-10s%-10s", sourceNodeIndex, targetNodeIndex, distances[targetNodeIndex]));
            }
        }
    }

    // Function that implements Dijkstra's single source
    // the shortest path algorithm for a graph represented using
    // adjacency list representation
    private static int[] dijkstra(List<List<Neighbour>> graph, int sourceNodeIndex) {
        // get the number of nodes or vertices in graph
        int numNodes = graph.size();
        // create array to store shortest distances from src
        int[] distances = new int[numNodes];
        // initialize default distance
        Arrays.fill(distances, Integer.MAX_VALUE);
        // initialize distances to src itself
        distances[sourceNodeIndex] = 0;

        // create min heap (priority queue)
        PriorityQueue<Neighbour> pq = new PriorityQueue<>((node1, node2) -> node1.getWeight() - node2.getWeight());
        // add source node to priority queu
        pq.add(new Neighbour(sourceNodeIndex, 0));
        // do bfs using pq
        while (!pq.isEmpty()){
            // get the closest node from priority queue (min heap)
            Neighbour currentNode = pq.poll();
            // iterate over all neighbours of currentNode
            for (Neighbour neighbour : graph.get(currentNode.nodeNumber)) {
                // calculate the distance of neighbour for src node
                // if it's less than current value, update distance array
                if (distances[currentNode.getNodeNumber()] + neighbour.getWeight() < distances[neighbour.getNodeNumber()]) {
                    // update distance
                    distances[neighbour.getNodeNumber()] = distances[currentNode.getNodeNumber()] + neighbour.getWeight();
                    // add neighbour to priority queue
                    // note the weight here indicates distance from src node index
                    pq.add(new Neighbour(neighbour.getNodeNumber(), distances[neighbour.getNodeNumber()]));
                }
            }
        }

        // return distances
        return distances;
    }

    private static List<List<Neighbour>> createAdjListGraph() {
        // number of nodes in a graph
        int numNodes = 9;
        // create graph represented by adjacency list
        List<List<Neighbour>> graph = new ArrayList<>(numNodes);
        // initialize graph
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }
        // link nodes with weighted edges
        graph.get(0).add(new Neighbour(1, 4));
        graph.get(0).add(new Neighbour(7, 8));
        graph.get(1).add(new Neighbour(2, 8));
        graph.get(1).add(new Neighbour(7, 11));
        graph.get(1).add(new Neighbour(0, 7));
        graph.get(2).add(new Neighbour(1, 8));
        graph.get(2).add(new Neighbour(3, 7));
        graph.get(2).add(new Neighbour(8, 2));
        graph.get(2).add(new Neighbour(5, 4));
        graph.get(3).add(new Neighbour(2, 7));
        graph.get(3).add(new Neighbour(4, 9));
        graph.get(3).add(new Neighbour(5, 14));
        graph.get(4).add(new Neighbour(3, 9));
        graph.get(4).add(new Neighbour(5, 10));
        graph.get(5).add(new Neighbour(4, 10));
        graph.get(5).add(new Neighbour(6, 2));
        graph.get(6).add(new Neighbour(5, 2));
        graph.get(6).add(new Neighbour(7, 1));
        graph.get(6).add(new Neighbour(8, 6));
        graph.get(7).add(new Neighbour(0, 8));
        graph.get(7).add(new Neighbour(1, 11));
        graph.get(7).add(new Neighbour(6, 1));
        graph.get(7).add(new Neighbour(8, 7));
        graph.get(8).add(new Neighbour(2, 2));
        graph.get(8).add(new Neighbour(6, 6));
        graph.get(8).add(new Neighbour(7, 1));

        return graph;
    }


    static class Neighbour {
        private int nodeNumber;
        private int weight;

        public Neighbour(int nodeNumber, int weight) {
            this.nodeNumber = nodeNumber;
            this.weight = weight;
        }

        public int getNodeNumber() {
            return nodeNumber;
        }

        public int getWeight() {
            return weight;
        }
    }
}
