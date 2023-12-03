package com.machineFactory.Service;

import com.machineFactory.Model.Customer;
import com.machineFactory.Model.Machine;
import com.machineFactory.Model.OrderModel;
import com.machineFactory.Model.Part;
import com.machineFactory.Repository.PartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PartService {

    private final PartRepo partRepo;

    @Autowired
    PartService(PartRepo partRepo) {
        this.partRepo = partRepo;
    }

    public Part findPartById(Long id) {
        return partRepo.findById(id).orElse(null);
    }


    public Part createPart(Part part) {
        return partRepo.save(part);
    }
}
