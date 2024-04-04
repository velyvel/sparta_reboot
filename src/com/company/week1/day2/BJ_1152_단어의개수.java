package src.com.company.week1.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1152_단어의개수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 주어진 문자열(예시 : The Curious Case of Benjamin Button)을 저장할 공간
        String sentence = br.readLine();
        //" The Curious Case of Benjamin Button " 이런 예시가 있을 수 있으니까 앞 뒤 공백 제거하고
        sentence =  sentence.trim();

        // 공백 제거했을 때 문자열 있으면
        if(!(sentence.isEmpty())) {
            //공백을 기준으로 나눠보시게..
            String[] strArray = sentence.split(" ");
            // 디버그 걸어보면 여기 출력값이 "The" "Curious" "Case" "of" "Benjamin" "Button"
            System.out.println(strArray.length);
        }
        // 빈문자열이면
        else {
            System.out.println(0);
        }


    }


}
