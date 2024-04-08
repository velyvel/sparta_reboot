package src.com.company.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18870_좌표압축_2 {
    // 문제 이해 못해서.. 어려웠다
    // 시간초과 코드

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] origin = new int[N];
        String[] input = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input[i]);
            origin[i] = Integer.parseInt(input[i]);
        }
        //int[] origin = array.clone();

        // 중복을 제거하고 정렬된 순서로 유지하기 위해 HashSet을 사용
        Set<Integer> set = new HashSet<>();
        for(int num : array) {
            set.add(num);
        }

        // TreeSet 사용하려 했으나.... indexOf 사용 못해서 리스트로 한번 더 바꿔줌.. 불필요한 작업
        TreeSet<Integer> sortedSet = new TreeSet<>(set);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // 정렬된 순서로 좌표의 인덱스를 출력
            sb.append(((TreeSet<Integer>) sortedSet).headSet(origin[i]).size()).append(" ");
        }
        System.out.println(sb);
    }
}
