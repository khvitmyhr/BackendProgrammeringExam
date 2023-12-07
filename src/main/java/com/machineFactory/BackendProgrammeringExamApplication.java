package com.machineFactory;

import com.github.javafaker.Faker;
import com.machineFactory.Model.*;
import com.machineFactory.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class BackendProgrammeringExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendProgrammeringExamApplication.class, args);
    }

        Faker faker = new Faker();
        @Bean
        CommandLineRunner commandLineRunner(
                CustomerRepo customerRepo,
                AddressRepo addressRepo,
                MachineRepo machineRepo,
                OrderRepo orderRepo,
                PartRepo partRepo,
                SubassemblyRepo subassemblyRepo,
                ArrayList<Subassembly> subassemblies,
                ArrayList<Part> parts
            ) {

            return args -> {

                Customer customer = customerRepo.save(new Customer("Frank", "h@hotmail.com"));

                for (int i = 0; i < 20; i++) {
                    Customer cus = customerRepo.save(new Customer(faker.name().fullName(), faker.internet().emailAddress()));
                    Address adr = addressRepo.save(new Address(faker.address().streetAddress(), faker.address().zipCode(), faker.address().cityName()));
                    cus.getAddresses().add(adr);
                    customerRepo.save(cus);
                }

                Subassembly subassemblyMotor = new Subassembly("Motor");
                Subassembly subassemblyGirkasse = new Subassembly("Girkasse");

                subassemblies.add(subassemblyMotor);
                subassemblies.add(subassemblyGirkasse);

                Machine machine = machineRepo.save(new Machine("Gressklipper"));
                Machine machine2 = machineRepo.save(new Machine("Traktor", subassemblies));

                Part part = new Part("stempel");
                Part part2 = new Part("sylinder");
                Part part3 = new Part("aksel");

                parts.add(part);
                parts.add(part2);
                parts.add(part3);

            };
        }
}

