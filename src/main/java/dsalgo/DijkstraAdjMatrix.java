package dsalgo;

import java.util.Arrays;

public class DijkstraAdjMatrix {

    public static void main(String[] args) {
        // create adj matrix graph
        int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        // get the number of nodes or vertices in graph
        int numNodes = graph.length;

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
    // adjacency matrix representation
    private static int[] dijkstra(int graph[][], int sourceNodeIndex) {
        // get the number of nodes or vertices in graph
        int numNodes = graph.length;
        // create array to store shortest distances from src
        int[] distances = new int[numNodes];
        // initialize default distance
        Arrays.fill(distances, Integer.MAX_VALUE);
        // initialize distances to src itself
        distances[sourceNodeIndex] = 0;
        // create a shortest path tree set
        boolean[] shortedPathTreeSet = new boolean[numNodes];

        // find shortest distances for all vertices from sourceNode
        for (int count = 0; count < numNodes; count++) {
            // Pick the minimum distance vertex from the set
            // of vertices not yet processed. minDistanceNodeIndex is always
            // equal to srcNodeIndex in first iteration.
            int minDistanceNodeIndex = minDistance(distances, shortedPathTreeSet, numNodes);
            // Mark the picked vertex as processed
            shortedPathTreeSet[minDistanceNodeIndex] = true;
            // Update dist value of the adjacent vertices of
            // the picked vertex.
            for (int targetNodeIndex = 0; targetNodeIndex < numNodes; targetNodeIndex++) {
                // Update dist[v] only if is not in sptSet,
                // there is an edge from u to v, and total
                // weight of path from src to v through u is
                // smaller than current value of dist[v]
                if (
                        !shortedPathTreeSet[targetNodeIndex] && graph[minDistanceNodeIndex][targetNodeIndex] != 0
                        && distances[minDistanceNodeIndex] != Integer.MAX_VALUE
                        && distances[minDistanceNodeIndex] + graph[minDistanceNodeIndex][targetNodeIndex] < distances[targetNodeIndex]
                ) {
                    distances[targetNodeIndex] = distances[minDistanceNodeIndex] + graph[minDistanceNodeIndex][targetNodeIndex];
                }
            }
        }
        return distances;
    }

    // A utility function to find the vertex with minimum
    // distance value, from the set of vertices not yet
    // included in the shortest path tree
    private static int minDistance(int distances[], boolean shortedPathTreeSet[], int numNodes) {
        int minPathWeight = Integer.MAX_VALUE;
        int minPathNodeIndex = -1;

        for (int targetNodeIndex = 0; targetNodeIndex < numNodes; targetNodeIndex++)
            if (shortedPathTreeSet[targetNodeIndex] == false && distances[targetNodeIndex] <= minPathWeight) {
                minPathWeight = distances[targetNodeIndex];
                minPathNodeIndex = targetNodeIndex;
            }

        return minPathNodeIndex;
    }
}
