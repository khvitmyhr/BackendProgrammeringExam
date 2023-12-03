package com.machineFactory.Service;

import com.machineFactory.Model.Address;
import com.machineFactory.Model.Customer;
import com.machineFactory.Model.Machine;
import com.machineFactory.Repository.MachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineService {

    private final MachineRepo machineRepo;

    @Autowired
    MachineService(MachineRepo machineRepo) {
        this.machineRepo = machineRepo;
    }

    public Machine findMachineById(Long id) {
        return machineRepo.findById(id).orElse(null);
    }

    public Machine createMachine(Machine machine) {
        return machineRepo.save(machine);
    }
}
