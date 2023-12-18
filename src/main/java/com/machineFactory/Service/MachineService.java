package com.machineFactory.Service;

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

    public List<Machine> getAllMachinesWithPagination(int pageNr) {
        return machineRepo.findAll(PageRequest.of(pageNr, 5)).stream().toList();
    }

    public List<Machine> getAllMachines() {
        return machineRepo.findAll();
    }

    public Machine createMachine(Machine machine) {
        return machineRepo.save(machine);
    }

    public void deleteMachine(Long id) {
        machineRepo.deleteById(id);
    }

    public boolean updateMachine(Long id, String type) {
        Machine machine = machineRepo.findById(id).orElse(null);
        if (machine != null) {
            machine.setMachineName(type);
            machineRepo.save(machine);
            return true;
        }
        return false;
    }
}
