package httptest.HttpServer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

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

        Integer result = completableFuture.get();
        System.out.println(result);
    }

}
