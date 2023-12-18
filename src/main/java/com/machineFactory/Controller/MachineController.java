package com.machineFactory.Controller;

import com.machineFactory.Model.Machine;
import com.machineFactory.Service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping ("{id}/{type}")
    public ResponseEntity<String> updateMachineType(@PathVariable Long id, @PathVariable String type) {
        if (machineService.updateMachine(id, type)) {
            return new ResponseEntity<>("Machine updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("No machine with this id", HttpStatus.NOT_FOUND);
    }
}


