package com.example.machineFactory.Service;

import com.example.machineFactory.Repository.PartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartService {

    private final PartRepo partRepo;

    @Autowired
    PartService(PartRepo partRepo) {
        this.partRepo = partRepo;
    }
}
