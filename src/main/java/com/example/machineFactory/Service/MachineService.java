package com.example.machineFactory.Service;

import com.example.machineFactory.Repository.MachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineService {

    private final MachineRepo machineRepo;

    @Autowired
    MachineService(MachineRepo machineRepo) {
        this.machineRepo = machineRepo;
    }
}
