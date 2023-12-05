package com.machineFactory.Service;

import com.machineFactory.Model.Address;
import com.machineFactory.Model.Machine;
import com.machineFactory.Repository.MachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Machine> getAllMachinesWithPagination(int pageNumber) {
        return machineRepo.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public Machine createMachine(Machine machine) {
        return machineRepo.save(machine);
    }

    public void deleteMachine(Long id) {
        machineRepo.deleteById(id);
    }
}
