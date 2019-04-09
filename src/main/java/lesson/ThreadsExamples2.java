package lesson;

public class ThreadsExamples2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        while (true){           // по моему можно вмето этого указать while(t1.isAlive()){ }
            if(!t1.isAlive()){  // и программа будет "находиться" на этом участке кода, пока поток не завершится
                break;
            }
        }

        System.out.println("END");
    }
}
