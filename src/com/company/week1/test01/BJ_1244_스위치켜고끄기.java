package src.com.company.week1.test01;

import java.io.*;


public class BJ_1244_스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int switchNum = Integer.parseInt(br.readLine());
        String[] switchCondition = br.readLine().split(" "); // 스위치 상태를 한 줄로 입력받아 처리

        int totalStudent = Integer.parseInt(br.readLine());

        for (int i = 0; i < totalStudent; i++) {
            String[] student = br.readLine().split(" ");
            int gender = Integer.parseInt(student[0]);
            int selectedNum = Integer.parseInt(student[1]); // 스위치 번호는 1부터 시작

            if (gender == 1) {
                for (int j = selectedNum; j <= switchNum; j += selectedNum) {
                    int idx = j - 1; // 배열 인덱스는 0부터 시작
                    switchCondition[idx] = switchCondition[idx].equals("0") ? "1" : "0";
                }
            } else {
                int idx = selectedNum - 1; // 배열 인덱스는 0부터 시작
                int left = idx, right = idx;

                // 대칭 범위 확장
                while (left > 0 && right < switchNum - 1 && switchCondition[left - 1].equals(switchCondition[right + 1])) {
                    left--;
                    right++;
                }

                // 대칭 범위 내 스위치 상태 변경
                for (int k = left; k <= right; k++) {
                    switchCondition[k] = switchCondition[k].equals("0") ? "1" : "0";
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < switchNum; i++) {
            bw.write(switchCondition[i]);
            if (i % 20 == 19 || i == switchNum - 1) {
                bw.newLine();
            } else {
                bw.write(" ");
            }
        }
        bw.flush();
        bw.close();
    }
}
