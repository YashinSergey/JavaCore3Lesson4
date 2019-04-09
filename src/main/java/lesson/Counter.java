package lesson;

public class Counter {
    private int c;

    Counter() {
        this.c = 0;
    }

    int getC() {
        return c;
    }

    void setC(int c) {
        this.c = c;
    }

    synchronized void decrement(){
        c--;
    }

    synchronized void increment(){
        c++;
    }
}

class MainCounter {
    public static void main(String[] args) {
        final Counter counter = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    counter.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    counter.decrement();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        while (t1.isAlive() || t2.isAlive()){
//
//        }
        System.out.println(counter.getC());

    }
}
