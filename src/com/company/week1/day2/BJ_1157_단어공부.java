package src.com.company.week1.day2;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BJ_1157_단어공부 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine().toUpperCase();

        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();

        int max = 0;

        for(int i = 0; i < sentence.length(); i++) {
            //ZZA -> Z,0 -> 한바꾸 돌았을때 max 1
            char alphabet = sentence.charAt(i);
            // 맵에 알파벳이 있으면 value(값) 에 +1 해주기
            map.put(alphabet, map.getOrDefault(alphabet,0) + 1);
            // 최고값 갱신하기
            max = Math.max(max, map.get(alphabet));
        }

        /**Map.Entry<Character, Integer> map 반복문 돌리는 일반적인 방법( Map 내의 키-값 쌍을 나타낸다)
         * for문 돌면서 entry.getKey()를 통해 문자열 반복하고, value는 횟수를 반환하도록 함
         */

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            // 가장 많은 알파벳 리스트에 추가 : A->1 A, value 1 Z -> 2
            if(entry.getValue() == max) {
                // 여기서 key 는 알파벳!
                list.add(entry.getKey());
            }
        }

        // 리스트에 1개 이상(그니까 최대로 가진 알파멧이 여러개 이면 (zZa 일 경우 : list.size = false)
        if (list.size() > 1) {
            System.out.println("?");
        } else {
            // 반대로 리스트에 한개만 있으면 그 리스트 출력
            System.out.println(list.get(0));
        }

    }

}
