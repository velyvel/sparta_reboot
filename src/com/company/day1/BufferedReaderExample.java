package src.com.company.day1;

import java.io.*;

public class BufferedReaderExample {

    public static void main(String[] args) throws IOException {

        long before = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.print("이름을 입력하세요: ");
        String name = br.readLine(); // 문자열 입력받기

        System.out.print("나이를 입력하세요: ");
        int age = Integer.parseInt(br.readLine()); // 나이 입력(string)받고 Integer로 감싸주

        //받은 데이터 출력
        System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age + "살입니다.");

        br.close();
        long after = System.currentTimeMillis();
        System.out.println("걸린 시간은 : " + (after - before)/1000);
    }
}
