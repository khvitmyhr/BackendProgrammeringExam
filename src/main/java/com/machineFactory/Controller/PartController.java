package com.machineFactory.Controller;

import com.machineFactory.Model.Customer;
import com.machineFactory.Model.Part;
import com.machineFactory.Service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
