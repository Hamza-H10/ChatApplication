package com.java;

class MyThr2 extends Thread {
    public void run() {
        int i = 0;
        while (i<56666) {
            System.out.println("Thank you");
           i++;
    }
        while (true) {  //this method will make the thread sleep for the desired milisec
            System.out.println("Thank you");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}
    class MyThr3 extends Thread {
        public void run() {
            while (true) {
                System.out.println("My Thank you ");
            }
        }
    }
public class thread_methods {
    public static void main(String[] args) {
        MyThr2 t1 = new MyThr2();
//      MyThr2 t2 = new MyThr2();//obj t2 from same class
        MyThr3 t2 = new MyThr3();//obj t2 from other class
        t1.start();
//        try{
//            t1.join();
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
        t2.start();
    }
    }

