package com.example.machineFactory.Service;

import com.example.machineFactory.Repository.SubassemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubassemblyService {

    private final SubassemblyRepo subassemblyRepo;

    @Autowired
    SubassemblyService(SubassemblyRepo subassemblyRepo) {
        this.subassemblyRepo = subassemblyRepo;
    }
}
