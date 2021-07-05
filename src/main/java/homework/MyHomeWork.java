package homework;

public class MyHomeWork {
    int count1,count2,count3 = 0;
    String str;

    public static void main(String[] args) {
        MyHomeWork hw = new MyHomeWork();
            hw.thread1.start();
            hw.thread2.start();
            hw.thread3.start();
    }

    synchronized void printA(){
        while (count1 < 5){
            if(str == null || str.equals("C")) {
                System.out.print("A");
                str = "A";
                count1++;
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    synchronized void printB(){
        while (count2 < 5){
            if(str.equals("A")){
                System.out.print("B");
                str = "B";
                count2++;
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    synchronized void printC(){
        while (count3 < 5){
            if(str.equals("B")){
                System.out.print("C");
                str = "C";
                count3++;
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            printA();
        }
    });

    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            printB();
        }
    });

    Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            printC();
        }
    });
}
