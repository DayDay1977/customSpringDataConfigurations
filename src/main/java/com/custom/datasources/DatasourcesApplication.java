package com.custom.datasources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatasourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasourcesApplication.class, args);
    }
}
