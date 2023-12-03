package com.machineFactory;

import com.machineFactory.Model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendProgrammeringExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendProgrammeringExamApplication.class, args);

        //Testbruker
        Customer customer = new Customer("Frank", "h@hotmail.com");
    }
}

