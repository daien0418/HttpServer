package httptest.HttpServer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class GuavaTest {

    public static void main(String args[]) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);
        ListenableFuture<Integer> listenableFuture = listeningExecutorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 123;
            }
        });

        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {

            public void onFailure(Throwable arg0) {
                // TODO Auto-generated method stub
            }

            public void onSuccess(Integer arg0) {
                System.out.println(arg0);
            }
        }, listeningExecutorService);

        Multimap<String, Integer> multimap = HashMultimap.create();
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("first", 1);
        biMap.put("second", 2);
        biMap.inverse();

    }

}
