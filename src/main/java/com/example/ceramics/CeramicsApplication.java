package com.example.ceramics;

import com.example.ceramics.util.DataUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CeramicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CeramicsApplication.class, args);

        DataUtils dataUtils = new DataUtils();
        dataUtils.sampleMap();
    }

}
