package com.company.day0;

import java.util.Scanner;

public class BJ_2753 {

    // 윤년 계산하기
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            year = 1;
            System.out.println(year);
        } else {
            year = 0;
            System.out.println(year);
        }

    }
}
