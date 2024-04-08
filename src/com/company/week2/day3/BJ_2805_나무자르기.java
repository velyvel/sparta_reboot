package src.com.company.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 메모리 : 14256KB, 시간 132ms
 * 들어가는 차 큐, 나오는 차 큐랑 비교
 * 들어간 차 peek 랑 나오는 차 다르면 추월(count++) 그대로 진행하면 밀리니까
 * inQueue에 있는 비교한 차는 제거
 * 들어간 차 나온차 똑같으면 꺼내놓기(착한차들이니끼)
 --------------------------------------------------
 */

public class BJ_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        // 나무의 수
        int N = Integer.parseInt(input[0]);
        // 필요한 나무의 길이
        int M = Integer.parseInt(input[1]);

        // 가장 높은 나무 저장할 변수 : 절단기 최대로 높일 수 있는 값이니까..
        int top = 0;
        // 나무 저장 배열
        int[] trees = new int[N];

        String[] treesStr = br.readLine().split(" ");
        for(int i= 0; i < N; i++) {
            trees[i] = Integer.parseInt(treesStr[i]);
            if(top < trees[i]) {
                top = trees[i];
            }
        }

        // 절단기 높이 찾기 (매개변수로 나무배열, 가장 높은 나무, 필요한 나무 길이 입력)
        int answer = findHeights(trees, top, M);
        System.out.println(answer);

    }

    public static int findHeights(int[] trees, int top, int M) {
        int start = 0;

        // 절단기 높이 탐색 : 땅에서 ~ 가장 큰 나무까지 반복
        while (start < top) {
            // 일단 반 잘라보고 아래로 갈지 위로 올라갈지 정함
            int middle = (start + top) / 2;
            // 나무 잘랐을 때 얻을 수 있는 나무길이(기준 : M)
            // int sum = 0;
            long sum = 0;

            for (int tree : trees) {
                // tree - middle (반으로 잘랐을 때 잘리는것)
                if(tree - middle > 0) {
                    //만 더해준다
                    sum += (tree - middle);
                }
            }

            // 잘라서 합친(잘린 가지의 높이 합)이 M(내가 필요한 나무길이) 보다 작으면
            if(sum < M) {
                //나무 반보다 더 잘라야 하니까 절단기 높이를 줄여준다 (20이라면 10, 10 아래부터 다시 탐색)
                top = middle;
            }
            // 필요한 만큼 잘렸거나 더 많이 잘렸으면 -> 절단기 높이 올려준다
            else {
                //반 자른 것보다 1m 더 올려준다 -> 똑같은 반이 될 수는 없으니까
                start = middle + 1;

            }
        }
        // 여기서 헷갈렸다..절단기가 최소한으로 잘라줘야 하는 길이가 있으니까..
//        return start;
        return start -1;
    }

}
