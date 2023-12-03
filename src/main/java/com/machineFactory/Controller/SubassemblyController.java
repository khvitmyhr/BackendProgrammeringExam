package com.machineFactory.Controller;

import com.machineFactory.Model.Customer;
import com.machineFactory.Model.Part;
import com.machineFactory.Model.Subassembly;
import com.machineFactory.Repository.SubassemblyRepo;
import com.machineFactory.Service.SubassemblyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
