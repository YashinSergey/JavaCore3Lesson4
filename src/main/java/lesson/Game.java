package lesson;

public class Game {
    Object chair1 = new Object();
    Object chair2 = new Object();

    public static void main(String[] args) {
        Game game = new Game();
        game.human1.start();
        game.human2.start();
        game.human3.start();
    }

    Thread human1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Человек 1 подошел к стулу 1");
            synchronized (chair1){
                System.out.println("Человек 1 сел на стул 1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Человек 1 встал со стула 1");
            }
        }
    });

    Thread human2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Человек 2 подошел к стулу 1");
            synchronized (chair1){
                System.out.println("Человек 2 сел на стул 1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Человек 2 встал со стула 1");
            }
        }
    });

    Thread human3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Человек 3 подошел к стулу 2");
            synchronized (chair2){
                System.out.println("Человек 3 сел на стул 2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Человек 3 встал со стула 2");
            }
        }
    });
}
