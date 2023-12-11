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
                ArrayList<Subassembly> subassemblieListForTractor,
                ArrayList<Subassembly> subassemblieListForChainSaw,
                ArrayList<Part> partsForMotor,
                ArrayList<Part> partsForGearbox,
                ArrayList<Part> partsForChain
            ) {

            return args -> {

                //Faker that generates customers and addresses
                for (int i = 0; i < 20; i++) {
                    Customer customer = customerRepo.save(new Customer(faker.name().fullName(), faker.internet().emailAddress()));
                    Address address = addressRepo.save(new Address(faker.address().streetAddress(), faker.address().zipCode(), faker.address().cityName()));
                    customer.getAddresses().add(address);
                    customerRepo.save(customer);
                }

                Part pistonPart = new Part("Piston"); //Stempel
                Part cylinderPart = new Part("Cylinder");
                Part shaftPart = new Part("Shaft"); //aksel
                Part sawtoothPart = new Part("Sawtooth"); //Sagtann

                partsForMotor.add(pistonPart);
                partsForMotor.add(cylinderPart);
                partsForGearbox.add(shaftPart);
                partsForChain.add(sawtoothPart);

                Subassembly subassemblyMotor = new Subassembly("Motor", partsForMotor);
                Subassembly subassemblyGearbox = new Subassembly("Gearbox", partsForGearbox);
                Subassembly subassemblySaw = new Subassembly("Chain", partsForChain);

                subassemblieListForTractor.add(subassemblyMotor);
                subassemblieListForTractor.add(subassemblyGearbox);

                subassemblieListForChainSaw.add(subassemblySaw);
                subassemblieListForChainSaw.add(subassemblyMotor);

                Machine machine = machineRepo.save(new Machine("Chainsaw", subassemblieListForChainSaw));
                Machine machine2 = machineRepo.save(new Machine("Traktor", subassemblieListForTractor));

            };
        }
}

