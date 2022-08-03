package com.mehdisarf.communicationclientdemo.client.practices;

import okhttp3.*;

import java.io.IOException;

public class OkHttpDemo {

    public static void sendGetRequest() throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:8080/persons")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println();
        System.out.println(response);
        System.out.println(response.body().string());
        System.out.println(response.headers().names());
        System.out.println(response.headers().get("Keep-Alive"));
        System.out.println(response.body().contentLength());
        System.out.println(response.body().contentType());
    }

    public static void sendPostRequest() throws IOException {
        String jsonString = "{ \"firstName\": \"mehdi\", \"lastName\": \"sarf\" }";

        OkHttpClient client = new OkHttpClient();
        RequestBody requestBodyWithJsonBody = RequestBody.create(MediaType.parse("application/json"), jsonString);
        Request request = new Request.Builder()
                .url("http://localhost:8080/persons")
                .post(requestBodyWithJsonBody)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response);
        System.out.println(response.body().string());
    }
}