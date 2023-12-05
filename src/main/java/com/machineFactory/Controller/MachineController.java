package com.machineFactory.Controller;


import com.machineFactory.Model.Machine;
import com.machineFactory.Service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/page/{pageNr}")
    public List<Machine> getMachineByPage(@PathVariable int pageNr) {
        return machineService.getAllMachinesWithPagination(pageNr);
    }

    @PostMapping
    public Machine createMachine(@RequestBody Machine machine) {
        return machineService.createMachine(machine);
    }
    @DeleteMapping("/{id}")
    public void deleteMachineById(@PathVariable Long id) {
        machineService.deleteMachine(id);
    }
}
