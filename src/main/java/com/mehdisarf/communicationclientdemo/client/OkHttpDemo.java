package com.mehdisarf.communicationclientdemo.client;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OkHttpDemo {

    public static void sendTwoRequestSimultaneouslyCleanVersion() {
        String jsonContentType = "application/json";
        String JSON_BODY = "{ \"firstName\": \"mehdi\", \"lastName\": \"sarf\" }";
        OkHttpClient client = new OkHttpClient();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            RequestBody requestBody = RequestBody.create(MediaType.parse(jsonContentType), JSON_BODY);
            Request postRequest = new Request.Builder().url("http://localhost:8080/sleeppersons").post(requestBody).build();
            try {
                Response postResponse = client.newCall(postRequest).execute();
                System.out.println("Response Of POST req: " + postResponse);
                System.out.println("Response Body Of POST req: " + postResponse.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            Request getRequest = new Request.Builder().url("http://localhost:8080/sleeppersons").get().build();
            try {
                Response getResponse = client.newCall(getRequest).execute();
                System.out.println("Response Of GET req: " + getResponse);
                System.out.println("Response Body Of GET req: " + getResponse.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}