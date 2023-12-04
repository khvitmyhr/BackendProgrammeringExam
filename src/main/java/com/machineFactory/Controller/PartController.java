package com.machineFactory.Controller;

import com.machineFactory.Model.Part;
import com.machineFactory.Service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/part")
public class PartController {

    private final PartService partService;

    @Autowired
    PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/{id}")
    public Part getPartById(@PathVariable Long id) {
        return partService.findPartById(id);
    }

    @PostMapping
    public Part createPart(@RequestBody Part part) {
        return partService.createPart(part);
    }

    @DeleteMapping("/{id}")
    public void deletePartById(@PathVariable Long id) {
        partService.deletePart(id);
    }
}
