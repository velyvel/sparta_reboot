package src.com.company.week1.day4;

import java.io.*;
import java.util.Arrays;


public class BJ_1764_듣보잡 {
    public static void main(String[] args) throws IOException {

        // 시간초과!  이중포문 안쓰는 법 찾기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        // 듣 몇명?
        int N = Integer.parseInt(input[0]);
        // 보 몇명?
        int M = Integer.parseInt(input[1]);

        // 듣 명단
        String[] deudArray = new String[N];

        for(int i= 0; i< N; i++) {
            deudArray[i] = br.readLine();
        }

        // 어챠피 여기서 정렬래서 비교해버렷!
        Arrays.sort(deudArray);
        //ArrayList<String> deudboArray = new ArrayList<>();

        int memberCount = 0;

        for(int i = 0; i < M; i++) {
            // 보 명단 받는다
            String boMember = br.readLine();
            //위에 있는 듣 명단이랑 비교(듣 배열 수 만큼 돌기)
            for(int j = 0; j < N; j++) {
                // 듣 맴버와 보 멤버 같니 ?
                if(deudArray[j].equals(boMember)) {
                    memberCount++;
                    //deudboArray.add(deudArray[j]);
                    bw.write(deudArray[j] + "\n");

                }
            }
        }

        System.out.println(memberCount);
        bw.flush();
        // for 문 한번 더 돌아서 시간초과 -> bufferedWriter 로 수정
//        for (String deudboMember : deudboArray) {
//            System.out.println(deudboMember);
//        }
    }
}
