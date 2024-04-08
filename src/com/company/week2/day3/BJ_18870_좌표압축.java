package src.com.company.week2.day3;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class BJ_18870_좌표압축 {
    // 문제 이해 못해서.. 어려웠다
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 정렬 한 것
        int[] array = new int[N];
        String[] input = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        // 정렬 안한거
        int[] notSortedArray = array.clone();

        Arrays.sort(array);

        int index = 0;
        // 키 : 정렬된 배열의 값, 값 : 인덱스로 된 맵 선언 후 값 집어넣기
        HashMap<Integer, Integer> point = new HashMap<>();
        for(int i = 0; i < N; i++) {
            // 정렬된 배열의 요소에 같은 값이 있을 때 [-10, -9, 2, 4, 4] 일 경우 4,
            // 맵에 추가로 저장해줘야 하니까 인덱스 추가해 넣어준다
            if(!point.containsKey(array[i])) {
                point.put(array[i], index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
//            String stringA = Integer.toString(point.get(notSortedArray[i]));
//            char charval = stringA.charAt(0);
//            bw.write(charval + " ");
            sb.append(point.get(notSortedArray[i])).append(" ");
        }
        System.out.println(sb);

//        bw.flush();
//        bw.close();

    }
}
