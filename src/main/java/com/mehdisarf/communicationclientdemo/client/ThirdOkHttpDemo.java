package com.mehdisarf.communicationclientdemo.client;

import okhttp3.*;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ThirdOkHttpDemo implements Runnable {

    @Override
    public void run() {
        String jsonString = "{ \"firstName\": \"mehdi\", \"lastName\": \"sarf\" }";

        OkHttpClient client = new OkHttpClient();
        RequestBody requestBodyWithJsonBody = RequestBody.create(MediaType.parse("application/json"), jsonString);
        Request request = new Request.Builder()
                .url("http://localhost:8080/sleeppersons")
                .post(requestBodyWithJsonBody)
                .build();

        try {
            System.out.println("\nthread: " + Thread.currentThread().getName() + " << Before execute() " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + ">>");
            Response response = client.newCall(request).execute();
            System.out.println("thread: " + Thread.currentThread().getName() +" << After execute() " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + ">>");
            System.out.println(response);
            System.out.println(response.body().string());
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}