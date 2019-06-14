package httptest.HttpServer;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpTest {

    public static void main(String args[]){

        String url = "http://127.0.0.1:8888";

        OkHttpClient  ok = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.parse("text/x-markdown; charset=utf-8"), "{\"tenant_name\":\"test\",\"value\":\"100\"}"))
                .build();
        Call call = ok.newCall(request);
        call.enqueue(new Callback() {

            public void onResponse(Call arg0, Response arg1) throws IOException {
                System.out.println("success");
            }

            public void onFailure(Call arg0, IOException arg1) {
                System.out.println("fail");
            }
        });
        System.out.println("已发送，等待响应。。。。");
    }

}
