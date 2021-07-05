package lesson;

public class TestStop {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //Thread.currentThread().interrupt();
                        break;
                    }
                    System.out.println("A");
                }
            }
        });
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();
        System.out.println("END");
    }
}
