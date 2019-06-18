package httptest.HttpServer;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

public class CompletableTest {

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            public String get() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "t_o";
            }
        }).thenApply(new Function<String, Integer>() {
            public Integer apply(String t) {
                System.out.println(t);
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 1;
            }
        });

        System.out.println("start....");

        Integer result = completableFuture.get();
        System.out.println(result);
    }

    @Test
    public void whencomplete() throws InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {}
                if (new Random().nextInt() % 2 >= 0) {
                    int i = 12 / 0;
                }
            }
        }).whenComplete(new BiConsumer<Void, Throwable>() {

            public void accept(Void t, Throwable u) {
                System.out.println("done");
            }

        }).exceptionally(new Function<Throwable, Void>() {

            public Void apply(Throwable t) {
                t.printStackTrace();
                System.out.println("fail");
                return null;
            }
        });

        System.err.println("start..");
        TimeUnit.SECONDS.sleep(5);
    }

}
