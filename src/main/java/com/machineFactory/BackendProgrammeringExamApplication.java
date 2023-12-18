package com.machineFactory;

import com.github.javafaker.Faker;
import com.machineFactory.Model.*;
import com.machineFactory.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

@SpringBootApplication
public class BackendProgrammeringExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendProgrammeringExamApplication.class, args);
    }


    @Autowired
    private Environment environment;

    Faker faker = new Faker();

    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepo customerRepo,
            AddressRepo addressRepo,
            MachineRepo machineRepo,
            OrderRepo orderRepo,
            PartRepo partRepo,
            SubassemblyRepo subassemblyRepo,
            ArrayList<Address> addresses,
            ArrayList<Customer> customers,
            ArrayList<Machine> machines,
            ArrayList<Subassembly> subassemblieListForTractor,
            ArrayList<Subassembly> subassemblieListForChainSaw,
            ArrayList<Part> partsForMotor,
            ArrayList<Part> partsForGearbox,
            ArrayList<Part> partsForChain
        ) {

        return args -> {
            Boolean environmentCheck = environment.getProperty("testdata",  Boolean.class, false);

            if (environmentCheck) {

                //Faker that generates customers and addresses
                for (int i = 0; i < 5; i++) {
                    Customer customer = customerRepo.save(new Customer(faker.name().fullName(), faker.internet().emailAddress()));
                    Address address = addressRepo.save(new Address(faker.address().streetAddress(), faker.address().zipCode(), faker.address().cityName()));
                    customer.getAddresses().add(address);
                    customerRepo.save(customer);
                }

                Part pistonPart = new Part("Piston");
                Part cylinderPart = new Part("Cylinder");
                Part shaftPart = new Part("Shaft");
                Part sawtoothPart = new Part("Sawtooth");

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

                Machine machine1 = machineRepo.save(new Machine("Chainsaw", subassemblieListForChainSaw));
                Machine machine2 = machineRepo.save(new Machine("Traktor", subassemblieListForTractor));

                //Creates an order
                Customer customer1 = new Customer("Jens");
                customerRepo.save(customer1);
                machines.add(machine1);
                OrderModel order1 = orderRepo.save(new OrderModel(customer1, machines));

                //Create a customer, and add an address to it
                Customer customer = customerRepo.save(new Customer("Helga", "helga@gmail.com"));
                Address address = addressRepo.save(new Address("Løkkaveien 8", "8930", "Bergen"));
                addresses.add(address);
                customer.setAddresses(addresses);
                customerRepo.save(customer);

                //Create an address, and add it to a customer
                Address address2 = addressRepo.save(new Address("Kyllingveien 3", "9483", "Tromsø"));
                Customer customer2 = customerRepo.save(new Customer("Johny", "johny@gmail.com"));
                customers.add(customer2);
                address2.setCustomers(customers);
                addressRepo.save(address2);
            }
        };
    }
}

