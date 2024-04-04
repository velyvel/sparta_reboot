package src.com.company.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_24265_알고리즘수업4_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //int n = Integer.parseInt(br.readLine());
        long n = Long.parseLong(br.readLine());
        System.out.println((n * (n - 1)) / 2);
        System.out.println(2);
    }

}
