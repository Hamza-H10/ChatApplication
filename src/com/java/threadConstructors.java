package com.java;

class Thread1 extends Thread implements Runnable{
    public Thread1(String name){
        super(name);
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("I am thread");
        }
    }

}
class MyThr extends Thread {
    public MyThr(String name) {
        super(name);
    }

    public void run() {
        int i = 34;
        System.out.println("Thank you");
//        while (true) {
//            System.out.println("I am a thread");
//        }
    }

}
public class threadConstructors {
    public static void main(String[] args) {
//        MyThr t1 = new MyThr("Hamza");
//        MyThr t2 = new MyThr("Ram Candr");
//        t1.start();
//        t2.start();
//        System.out.println("The id of this thread is " + t1.getId());
//        System.out.println("The id of this thread is " + t2.getId());
//        System.out.println("The name of this thread is " + t1.getName());
//        System.out.println("The name of this thread is " + t2.getName());
//        Thread1 bullet = new Thread1("Hamza");
//        Thread gun = new Thread();
//        gun.start();
          Thread1 t1 = new Thread1("Hamza");
          t1.start();
        System.out.println("The id of this thread is "+ t1.getId());
        System.out.println("The name of this thread is " + t1.getName());
    }
}
