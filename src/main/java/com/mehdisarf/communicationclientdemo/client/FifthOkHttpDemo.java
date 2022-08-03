package com.mehdisarf.communicationclientdemo.client;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FifthOkHttpDemo {

    public static void sendTwoRequestSimultaneously() {
        String jsonContentType = "application/json";
        String JSON_BODY = "{ \"firstName\": \"mehdi\", \"lastName\": \"sarf\" }";

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println("1............" + Thread.currentThread().getName());
        executorService.submit(() -> {
            OkHttpClient client = new OkHttpClient();
            System.out.println("2............" + Thread.currentThread().getName());
            RequestBody requestBody = RequestBody.create(MediaType.parse(jsonContentType), JSON_BODY);
            Request postRequest = new Request.Builder().url("http://localhost:8080/sleeppersons").post(requestBody).build();
            try {
                System.out.println("before post request");
                Response postResponse = client.newCall(postRequest).execute();
                System.out.println("after post request. received the response.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        System.out.println("3............" + Thread.currentThread().getName());
        executorService.submit(() -> {
            OkHttpClient client = new OkHttpClient();
            System.out.println("4............" + Thread.currentThread().getName());
            Request getRequest = new Request.Builder().url("http://localhost:8080/sleeppersons").get().build();

            try {
                System.out.println("before get request");
                Response getResponse = client.newCall(getRequest).execute();
                Thread.sleep(10000);
                System.out.println("after get request. received the response.");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("5............" + Thread.currentThread().getName());
        executorService.shutdown();
    }

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