package com.example.machineFactory.Controller;

import com.example.machineFactory.Repository.SubassemblyRepo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subassembly")
public class SubassemblyController {

    private final SubassemblyRepo subassemblyRepo;

    SubassemblyController(SubassemblyRepo subassemblyRepo) {
        this.subassemblyRepo = subassemblyRepo;
    }
}
