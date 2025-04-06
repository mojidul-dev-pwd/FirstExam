public class CheckingSync {

    public void testSync() throws InterruptedException {
        CountingSyncronized obj1 = new CountingSyncronized();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) obj1.increase();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) obj1.increase();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + obj1.increase_counter); // Likely less than 2000

    }

    public void testWithoutSync() throws InterruptedException {
        CountingWithoutSyncronized obj1 = new CountingWithoutSyncronized();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) obj1.increase();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) obj1.increase();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + obj1.increase_counter); // Likely less than 2000

    }
}
