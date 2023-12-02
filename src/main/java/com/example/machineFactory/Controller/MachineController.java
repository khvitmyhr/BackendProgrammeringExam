package com.example.machineFactory.Controller;

import com.example.machineFactory.Service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/machine")
public class MachineController {

    private final MachineService machineService;
    @Autowired
    MachineController(MachineService machineService) {
        this.machineService = machineService;
    }
}
