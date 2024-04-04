package src.com.company.week1.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2908_상수 {
    //ㅋㅋ 아니 상수가 staticㅋㅋㅋ 이름잌
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        // 읽어온 숫자로 된 문자열 거꾸로 뒤집기
        StringBuilder reversedA = new StringBuilder(input[0]).reverse();
        StringBuilder reversedB = new StringBuilder(input[1]).reverse();

        // 거꾸로 뒤집은거 다시 int 로 형변환
        int reversedIntA = Integer.parseInt(reversedA.toString());
        int reversedIntB = Integer.parseInt(reversedB.toString());

        // 더 큰 값 출력하기
        System.out.println(Math.max(reversedIntA, reversedIntB));

    }

}
