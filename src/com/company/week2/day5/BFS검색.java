package src.com.company.week2.day5;

import java.util.ArrayList;

public class BFS검색 {
    int count;
    boolean[] isVisited;
    ArrayList<Integer> queue;
    int[][] matrix;

    public BFS검색(int count) {
        this.count = count;
        isVisited = new boolean[count];
        queue = new ArrayList<Integer>();
        matrix = new int[count][count];
    }
    public void BFS경로() {
        queue.add(0);
        isVisited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.remove(0);
            System.out.println("지금 출력된 숫자(노드)는 ? " + node);

            for (int i = 0; i < count; i++) {
                if(matrix[node][i] != 0 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int count = 8;
        그래프그리기 graph = new 그래프그리기(count);
        BFS검색 bfs검색 = new BFS검색(count);
        //그래프에 선 추가 (0~1, 길이 1)
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 1);
        graph.addEdge(4, 5, 1);
        graph.addEdge(3, 7, 1);

        bfs검색.matrix = graph.getVertexMatrix();
        bfs검색.BFS경로();
    }
}
