package com.mehdisarf.communicationclientdemo;

import com.mehdisarf.communicationclientdemo.client.FifthOkHttpDemo;
import com.mehdisarf.communicationclientdemo.client.ForthOkHttpDemo;
import com.mehdisarf.communicationclientdemo.client.SecondOkHttpDemo;
import com.mehdisarf.communicationclientdemo.client.ThirdOkHttpDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CommunicationClientDemoApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(CommunicationClientDemoApplication.class, args);
        FifthOkHttpDemo.sendTwoRequestSimultaneouslyCleanVersion();

        /*
        List<Thread> threadList = new ArrayList<>(800);
        System.out.println("\n\n|||||||| START :" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n\n");

        for (int i = 0; i < 800; i++) {
            // threadList.add(new Thread(new ThirdOkHttpDemo()));
            threadList.add(new Thread(new ForthOkHttpDemo()));
        }
        for (int i = 0; i < 800; i++) {
            threadList.get(i).start();
        }
        for (int i = 0; i < 800; i++) {
            threadList.get(i).join();
        }
        System.out.println("\n\n|||||||| STOP :" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
         */
    }
}