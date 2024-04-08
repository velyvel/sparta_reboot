package src.com.company.week2.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2606_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터의 수
        int N = Integer.parseInt(br.readLine());
        // 컴퓨터 쌍의 수
        int line = Integer.parseInt(br.readLine());
        int[][] graph = new int[N + 1][N + 1];
        boolean[] isVisited = new boolean[N + 1];

        for(int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(graph, isVisited, 1);
        //System.out.println(Arrays.toString(isVisited));
        int answer = 0;
        for(int i = 0; i < isVisited.length; i++) {
            if(isVisited[i]){
                if(i == 1 ){
                    continue;
                }
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int[][] graph,  boolean[] isVisited, int start) {

        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        isVisited[start] = true;

        while(!stack.isEmpty()) {
            int N = stack.pop();
            for(int i = 1; i < graph.length; i++) {
                if(graph[N][i] ==1 && !isVisited[i]) {
                    isVisited[i] = true;
                    stack.push(i);
                }
            }
        }
    }
}
