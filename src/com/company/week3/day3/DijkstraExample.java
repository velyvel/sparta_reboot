package src.com.company.week3.day3;

import java.util.*;

public class DijkstraExample {
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 4, 0, 0, 0},
                {0, 0, 1, 7, 0, 0},
                {0, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 2, 0, 5},
                {0, 0, 0, 0, 0, 0}
        };
        int startNode = 0;

        int[] distances = dijkstra(graph, startNode);

        System.out.println("최단 거리:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("정점 " + i + ": " + distances[i]);
        }
    }

    static int[] dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.target;
            int dist = edge.weight;

            if (distances[node] < dist) continue;

            for (int i = 0; i < n; i++) {
                if (graph[node][i] != 0 && distances[i] > distances[node] + graph[node][i]) {
                    distances[i] = distances[node] + graph[node][i];
                    System.out.println("지금 지나간 노드는 ? " + i + "번, 거리(가중치) 는 ? " + distances[i] );
                    pq.offer(new Edge(i, distances[i]));
                }
            }
        }

        return distances;
    }
}
