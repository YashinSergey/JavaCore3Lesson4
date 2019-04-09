package lesson;

public class Test {

    public synchronized void method1(){
        System.out.println("m1 " + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("m2 " + Thread.currentThread().getName());
    }

    public void method3(){
        System.out.println("m3 " + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("m4 " + Thread.currentThread().getName());
    }
}

class StartTest1 {
    public static void main(String[] args) {
        final Test t1 = new Test();
        final Test t2 = new Test();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.method3();
            }
        }).start();
    }
}
