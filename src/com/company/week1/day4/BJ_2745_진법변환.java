package src.com.company.week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2745_진법변환 {
    // 그리디
    /** 진법 계산: 2진법 11001 ->  숫자 뒤집기 -> 10011 ->
     * 첫번째 자리부터 (해당수 : 1 * 1) +
     * 2진법이니까 2의 1제곱 : (해당 수  0 * 2)...
     * A : 10, B: 11....
     * charAt(i) - 55
     *
     * integer.parseInt -> 는 :
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String original = input[0];  // 변환할 문자열
        int numeral = Integer.parseInt(input[1]);  // 변환할 진법

        // 변환할 문자열을 거꾸로 뒤집음
        StringBuilder sb = new StringBuilder(original);
        original = sb.reverse().toString();
        //charAt(i) - 55 대신 사용할 수 았는 것 고민함
        int sum = 0;
        for(int i = 0; i < original.length(); i++) {
            char currentChar = original.charAt(i);
            int convertNum = 0;  // 현재 자리의 수

            if (Character.isDigit(currentChar)) {
                // 문자가 숫자인 경우 : 문자열 - 0 해서 숫자로 변경
                convertNum = currentChar - '0';
            }
            else if (Character.isUpperCase(currentChar)) {
                // 문자가 대문자 알파벳인 경우 : 현재 알파멧 문자가 'A'에서 얼마나 떨어졌는지 ?  그리고 A는 10이니까
                convertNum = currentChar - 'A' + 10;
            }
            // 여기는 문제에서 대문자만 나온다고 했다
//            else {
//                // 문자가 소문자 알파벳인 경우
//                convertNum = currentChar - 'a' + 10;
//            }

            // 변환된 숫자에 현재 자릿수의 진수를 곱하여 누적
            sum += (convertNum * Math.pow(numeral, i));
        }
        System.out.println(sum);
    }

}
