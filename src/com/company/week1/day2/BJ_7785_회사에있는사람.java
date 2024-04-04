package src.com.company.week1.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_7785_회사에있는사람 {
    /***
     * N : 출입 기록의 수
     * enter 출근 leave 퇴근
     * 아직 퇴근 안한 사람 사전순 역순으로 한줄에 한명씩 출력 : hash 사용해 풀기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //이름 : enter, 이름 : leave 식으로 생각해서 풀었다.
        Map<String, String> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            // 이름과 출퇴근여부를 맵에 담아둔다,
            map.put(split[0], split[1]);
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry<String, String> entry : map.entrySet()) {
            // enter 만 있는 경우
            if(entry.getValue().equals("enter")) {
                // 이름 저장하기
                list.add(entry.getKey());
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        //이 함수 신기하구만
//        for(String name : list) {
//            System.out.println(name);
//        }
        list.forEach(System.out::println);
    }




}
