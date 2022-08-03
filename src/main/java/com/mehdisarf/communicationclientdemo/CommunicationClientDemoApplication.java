package com.mehdisarf.communicationclientdemo;

import com.mehdisarf.communicationclientdemo.client.OkHttpDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CommunicationClientDemoApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(CommunicationClientDemoApplication.class, args);
        OkHttpDemo.sendTwoRequestSimultaneouslyCleanVersion();
    }
}