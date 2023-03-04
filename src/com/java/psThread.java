package com.java;

class PsThread1 extends Thread{
    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Good Morning");
//        }
//
    }
}
class PsThread2 extends Thread {
    public void run() {
        while (true) {
            System.out.println("Welcome");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

    public class psThread {
        public static void main(String[] args) {
            //Q-1

            PsThread1 t1 = new PsThread1();
            PsThread2 t2 = new PsThread2();
//        t1.setPriority(6);
//        t2.setPriority(9);
            System.out.println(t1.getPriority());
            System.out.println(t2.getPriority());


//            t2.start();
            t1.start();
            System.out.println(t1.getState());
            System.out.println(Thread.currentThread().getState());
        }
    }


