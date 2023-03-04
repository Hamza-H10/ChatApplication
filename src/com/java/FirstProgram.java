package com.java;

class MyThread1 extends Thread {
    @Override
    public void run() {
        int i=0;
        while (i<4000) {
            System.out.println("My cooking Thread is Running");
            System.out.println("I am happy!");
            i++;
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run(){
       int i=0;
        while(i<4000){
            System.out.println("Thread2 for chatting with her");
            System.out.println("I am super happy!");
            i++;
        }
    }
}
public class FirstProgram {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.start();
        t2.start();
    }
}


