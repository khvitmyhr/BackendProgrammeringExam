package com.machineFactory.Controller;

import com.machineFactory.Model.Customer;
import com.machineFactory.Model.Machine;
import com.machineFactory.Service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public Machine getMachineById(@PathVariable Long id) {
        return machineService.findMachineById(id);
    }

}
