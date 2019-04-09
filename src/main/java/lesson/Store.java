package lesson;

public class Store {
    private int product = 0;

    synchronized void get(){
        while (product < 1){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("Покупатель купил 1 ед. товара");
        System.out.printf("На складе %d единиц товара%n", product);
        notify();
    }

    synchronized void set(){
        while (product >= 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Производитель добавил 1 ед. товара");
        System.out.printf("На складе %d единиц товара%n", product);
        notify();
    }
}

class Manufacturer implements Runnable{
    Store store;

    Manufacturer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            store.set();
        }
    }
}

class Buyer implements Runnable{
    Store store;

    Buyer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        store.get();
    }
}

class MainShop {
    public static void main(String[] args) {
        Store store = new Store();

        Manufacturer manufacturer = new Manufacturer(store);
        Buyer buyer = new Buyer(store);

        new Thread(manufacturer).start();
        new Thread(buyer).start();
    }
}