package com.machineFactory;

import com.machineFactory.Model.Customer;
import com.machineFactory.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendProgrammeringExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendProgrammeringExamApplication.class, args);
    }
        @Bean
        CommandLineRunner commandLineRunner(
                CustomerRepo customerRepo,
                AddressRepo addressRepo,
                MachineRepo machineRepo,
                OrderRepo orderRepo,
                PartRepo partRepo,
                SubassemblyRepo subassemblyRepo
            ) {

            return args -> {
                Customer customer = customerRepo.save(new Customer("Frank", "h@hotmail.com"));
            };
        }
}

