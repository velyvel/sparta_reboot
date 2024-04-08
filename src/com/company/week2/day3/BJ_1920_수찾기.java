package src.com.company.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        Set<String> resultSet = new HashSet<>();

        for(int i = 0; i < N; i++) {
            resultSet.add(input[i]);
        }

        int[] resultArray = new int[M];
        for(int i = 0; i < M; i++) {
            if(resultSet.contains(input2[i])) {
                resultArray[i] = 1;
            } else {
                resultArray[i] = 0;
            }
        }

        for(int result : resultArray){
            System.out.println(result);
        }

    }
}
