package src.com.company.week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Graph> graph = new ArrayList<>();

       // 입력
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            graph.add(new Graph(x, y));
        }

        // x 좌표를 기준으로 정렬
        Collections.sort(graph);

        // 가장 높은 기둥의 인덱스와 높이 찾기
        int maxHeightIndex = 0;
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            if (graph.get(i).height > maxHeight) {
                maxHeight = graph.get(i).height;
                maxHeightIndex = i;
            }
        }

        // 창고 다각형의 넓이 계산
        int area = calculateArea(graph, maxHeightIndex);

        System.out.println(area);
    }

    // 창고 다각형의 넓이를 계산하는 메서드
    private static int calculateArea(ArrayList<Graph> buildings, int maxHeightIndex) {
        int area = 0;
        int leftMaxHeight = 0;
        int rightMaxHeight = 0;

        // 가장 높은 기둥을 기준으로 왼쪽 영역의 넓이 계산
        for (int i = 0; i < maxHeightIndex; i++) {
            leftMaxHeight = Math.max(leftMaxHeight, buildings.get(i).height);
            area += leftMaxHeight * (buildings.get(i + 1).x - buildings.get(i).x);
        }

        // 가장 높은 기둥을 기준으로 오른쪽 영역의 넓이 계산
        for (int i = buildings.size() - 1; i > maxHeightIndex; i--) {
            rightMaxHeight = Math.max(rightMaxHeight, buildings.get(i).height);
            area += rightMaxHeight * (buildings.get(i).x - buildings.get(i - 1).x);
        }

        // 가장 높은 기둥의 높이 추가
        area += buildings.get(maxHeightIndex).height;

        return area;
    }

    static class Graph implements Comparable<Graph> {
        int x; // x 좌표
        int height; // 기둥의 높이

        public Graph(int x, int height) {
            this.x = x;
            this.height = height;
        }

        // x 좌표를 기준으로 오름차순으로 정렬
        @Override
        public int compareTo(Graph other) {
            return Integer.compare(this.x, other.x);
        }
    }
}
