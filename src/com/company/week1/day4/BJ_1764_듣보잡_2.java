package src.com.company.week1.day4;

import java.io.*;
import java.util.*;


public class BJ_1764_듣보잡_2 {
    // 시간초과 나서 수정한 코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        // 듣 몇명?
        int N = Integer.parseInt(input[0]);
        // 보 몇명?
        int M = Integer.parseInt(input[1]);

        // 사전 정렬: treeset 사용하기
        Set<String> deudSet = new TreeSet<>();
        Set<String> boSet = new TreeSet<>();

        // 듣멤버 넣기
        for (int i = 0; i < N; i++) {
            deudSet.add(br.readLine());
        }

        // 듣보 몇명 ?
        int count = 0;

        // 보 맴버 넣기
        for (int i = 0; i < M; i++) {
            String boMember = br.readLine();
            boSet.add(boMember);
            if (deudSet.contains(boMember)) {
                count++;
            }
        }

        // 중복된 명단을 저장할 리스트
        List<String> deudboList = new ArrayList<>();
        // deudSet과 boSet의 교집합을 구하여 deudboList에 저장
        deudboList.addAll(deudSet);
        deudboList.retainAll(boSet);

        System.out.println(count);
        for (String deudboMember : deudboList) {
            System.out.println(deudboMember);
        }
    }
}
