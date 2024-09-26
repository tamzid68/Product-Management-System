package com.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SpringHmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHmsApplication.class, args);
        System.out.println("Hi Tamzid!");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("JDBC Driver loaded successfully");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}



