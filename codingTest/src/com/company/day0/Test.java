package com.company.day0;

public class Test {

    public static void main(String[] args) {
        System.out.println(eee(5));
    }

    public static int eee(int n) {
        if(n == 1 ){
            return 1;
        }else {
            return n * eee(n-1);
        }
    }
}
