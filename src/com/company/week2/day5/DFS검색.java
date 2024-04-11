package src.com.company.week2.day5;

import java.util.Stack;

public class DFS검색 {
    int count;
    boolean[] isVisited;
    Stack<Integer> stack;
    int[][] matrix;

    public DFS검색(int count) {
        this.count = count;
        isVisited = new boolean[count];
        stack = new Stack<Integer>();
        // 추가
        matrix = new int[count][count];
    }

    public void DFS경로() {
        stack.push(0);
        isVisited[0] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.println("지금 출력된 숫자(노드)? " + node);
            // 출력 : 지금 출력된 숫자(노드)?

            for (int i = 0; i < count; i++) {
                if(matrix[node][i] != 0 && !isVisited[i]) {
                    stack.push(i);
                    isVisited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int count = 8;
        그래프그리기 graph = new 그래프그리기(count);
        DFS검색 dfs검색 = new DFS검색(count);
        //그래프에 선 추가 (0~1, 길이 1)
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 1);
        graph.addEdge(4, 5, 1);
        graph.addEdge(3, 7, 1);

        dfs검색.matrix = graph.getVertexMatrix();
        dfs검색.DFS경로();
        // 0,1,3,7,4,5,2,6 or 0,2,6,5,4,1,3,7
    }

}
