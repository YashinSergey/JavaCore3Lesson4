package lesson;

public class Test3 {
    public synchronized static void method1(){
        for (int i = 0; i < 5; i++) {
            System.out.println("m1 " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m2 " + Thread.currentThread().getName());
        }
    }

    public synchronized static void method3(){
        for (int i = 0; i < 5; i++) {
            System.out.println("m3 " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m4 " + Thread.currentThread().getName());
        }
    }
}

class StartTest3 {
    public static void main(String[] args) {
        final Test3 t1 = new Test3();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Test3.method3();
            }
        }).start();
    }
}
