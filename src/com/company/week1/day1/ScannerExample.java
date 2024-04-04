package src.com.company.week1.day1;

import java.util.Scanner; // Scanner 클래스 임포트

public class ScannerExample {
    public static void main(String[] args) {

        long before = System.currentTimeMillis();

        Scanner scanner = new Scanner(System.in); // System.in으로부터 입력을 받을 Scanner 객체 생성

        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine(); // 사용자로부터 한 줄의 문자열 입력 받기

        System.out.print("나이를 입력하세요: ");
        int age = scanner.nextInt(); // 사용자로부터 정수 입력 받기

        // 입력 받은 데이터 출력
        System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age + "살입니다.");

        scanner.close(); // Scanner 객체 닫기
        long after = System.currentTimeMillis();
        System.out.println("걸린 시간은 : " + (after - before)/1000);


    }
}

