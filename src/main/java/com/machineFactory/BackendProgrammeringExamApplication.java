package com.machineFactory;

import com.machineFactory.Model.Customer;
import com.machineFactory.Model.Machine;
import com.machineFactory.Model.Part;
import com.machineFactory.Model.Subassembly;
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

