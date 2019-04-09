package lesson;

public class DeadLockExample {
    static Object lock1 = new Object();
    static Object lock2 = new Object();


    public static void main(String[] args) {
        DeadThredOne one = new DeadThredOne();
        DeadThredTwo two = new DeadThredTwo();
        one.start();
        two.start();
    }

    static class DeadThredOne extends Thread{
        @Override
        public void run(){
            synchronized (lock1){
                System.out.println("One держит lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("One ждет lock2");
                synchronized (lock2){
                    System.out.println("One держит lock1 и lock2");
                }
            }
        }
    }

    static class DeadThredTwo extends Thread{
        @Override
        public void run(){
            synchronized (lock2){
                System.out.println("Two держит lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Two ждет lock1");
                synchronized (lock1){
                    System.out.println("Two держит lock1 и lock2");
                }
            }
        }
    }
}
