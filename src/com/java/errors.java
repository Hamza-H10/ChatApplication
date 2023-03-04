package com.java;

import java.util.Scanner;
public class errors {
    public static void main(String[] args) {
//         write a program to print all prime numbers between 1 to 10
        for (int i = 0; i < 5; i++) {
            System.out.println(2 * i + 1);

            //RUNTIME ERROR
            int k;
            Scanner sc = new Scanner(System.in);
            k = sc.nextInt();
            System.out.println("Integer part of 1000 divided by k is " + 1000 / k);

        }
    }
}

