public class ThreadConfusion implements Runnable{
    public static void main(String[] args) {
        ThreadConfusion tc = new ThreadConfusion();
        Thread[] threads = new Thread[24];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tc);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

    }

    @Override
    public void run() {
        LazyInitSingleton lis = LazyInitSingleton.getInstance();
        System.out.println(lis.hashCode());
    }
}
