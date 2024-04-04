package src.com.company.week1.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_27160_할리갈리 {
    public static void main(String[] args) throws IOException {

        // map을 사용한 풀이 : 편하게 풀어봤다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 펼처진 카드의 개수 = 게임하는 사람의 수라고 생각하고 풀었다
        int N = Integer.parseInt(br.readLine());

        /** 과일 : 개수로 이루어 진 카드니까 맵을 생각했다(편하게 풀기) :
         * key(과일 이름)가 같은 value(개수)의 합이 5이면 yes, 아니면 no 출력
         */

        HashMap<String, Integer> fruit = new HashMap<>();

        for(int i = 0; i < N; i++) {
            // 반복을 돌면서 공백문자 찾는다 -> key, value 넣기
            //cards[0] : 과일,   cards[1] : 숫자
            String[] cards = br.readLine().split(" ");
            // 같은 과일이 있는지 찾기
            if(fruit.containsKey(cards[0])){
                // 같은 과일이 있으면 기존 값에다가 누적합 해주기
                fruit.put(cards[0], fruit.get(cards[0]) + Integer.parseInt(cards[1]));
            }
            else {
                fruit.put(cards[0], Integer.parseInt(cards[1]));
            }
        }
        // 이렇게 반복문으로 카드값 정리가 끝나면 과일맵에서 value(개수)가 5개 인지 찾는다.
        if(fruit.containsValue(5)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
