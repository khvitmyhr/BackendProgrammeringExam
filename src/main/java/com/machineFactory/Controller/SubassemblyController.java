package com.machineFactory.Controller;

import com.machineFactory.Model.Subassembly;
import com.machineFactory.Service.SubassemblyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subassembly")
public class SubassemblyController {

    private final SubassemblyService subassemblyService;

    SubassemblyController(SubassemblyService subassemblyService) {
        this.subassemblyService = subassemblyService;
    }

    @GetMapping("/{id}")
    public Subassembly getSubassemblyById(@PathVariable Long id) {
        return subassemblyService.findSubassemblyById(id);
    }

    @GetMapping("/page/{pageNr}")
    public List<Subassembly> getSubassemblyByPage(@PathVariable int pageNr) {
        return subassemblyService.getAllSubassemblysWithPagination(pageNr);
    }

    @PostMapping
    public Subassembly createSubassembly(@RequestBody Subassembly subassembly) {
        return subassemblyService.createSubassembly(subassembly);
    }

    @DeleteMapping("/{id}")
    public void deleteSubassemblyById(@PathVariable Long id) {
        subassemblyService.deleteSubassembly(id);
    }

    @PutMapping ("{id}/{type}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @PathVariable String type) {
        if (subassemblyService.updateSubassembly(id, type)) {
            return new ResponseEntity<>("Subassembly updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("No subassembly with this id", HttpStatus.NOT_FOUND);
    }
}
