package lesson;

public class Test2 {
    Object lock = new Object();

    public static void main(String[] args) {
        final Test2 test2 = new Test2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.method();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.method();
            }
        }).start();
    }

    public void method(){
        System.out.println("NonSync - Begin");
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("NonSync - END");

        synchronized (lock){
            System.out.println("Sync-Begin");
            for (int i = 0; i < 2; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Sync - END");
        }
    }
}
