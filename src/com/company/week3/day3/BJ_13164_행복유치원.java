package src.com.company.week3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13164_행복유치원 {
    /**
     * 메모리 : 52528KB, 시간 : 616ms
     * height[] : 원생 키,  differenceArray : 앞, 뒤 원생의 차 저장 배열
     *      -> 처음에는 1과 3, 1과 5, 1과 6 등등 조별로 나눌 수 있는 모든 경우의 수에 대해서 고려하려 풀었으나, 시간초과
     * differenceArray 에 인접한 사람의 키 차이를 넣었다 이걸 오름차순으로 정렬! (비용 아끼려고)
     * 가장 큰 차이부터 K-1개까지는 묶어서 한 조로 만들고 더해주려고 했다
     * */
    static int N, K;
    static int[] heights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        heights = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int cost = calculateMinCost();
        System.out.println(cost);

    }

    private static int calculateMinCost() {
        int cost = 0;
        // 인접한 두 학생의 차 새로운 배열에 넣는다
        int[] differenceArray = new int[heights.length - 1];

        for(int i = 0; i < differenceArray.length; i++) {
            differenceArray[i] = heights[i + 1] - heights[i];
        }

        // 키차이가 적게 나는 순으로 정렬한다.
        Arrays.sort(differenceArray);

        // differenceArray : 5명, K 는 3조라면, 양 끝값의 차이만 필요하다
        // 가장 큰 차이부터 K-1개까지는 묶어서 한 조로 만든 후 값 더하기
        for(int i = 0; i < differenceArray.length - (K - 1); i++) {
            cost+= differenceArray[i];
        }

        return cost;
    }
}
