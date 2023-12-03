package com.machineFactory.Service;

import com.machineFactory.Model.Customer;
import com.machineFactory.Model.Subassembly;
import com.machineFactory.Repository.SubassemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubassemblyService {

    private final SubassemblyRepo subassemblyRepo;

    @Autowired
    SubassemblyService(SubassemblyRepo subassemblyRepo) {
        this.subassemblyRepo = subassemblyRepo;
    }

    public Subassembly findSubassemblyById(Long id) {
        return subassemblyRepo.findById(id).orElse(null);
    }
}
