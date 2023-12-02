package com.example.machineFactory.Controller;

import com.example.machineFactory.Service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
