package com.machineFactory.Service;

import com.machineFactory.Model.Part;
import com.machineFactory.Repository.PartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Part> getAllPartsWithPagination(int pageNr) {
        return partRepo.findAll(PageRequest.of(pageNr, 5)).stream().toList();
    }

    public List<Part> getAllParts() {
        return partRepo.findAll();
    }

    public Part createPart(Part part) {
        return partRepo.save(part);
    }

    public void deletePart(Long id) {
        partRepo.deleteById(id);
    }

    public boolean updatePart(Long id, String type) {
        Part part = partRepo.findById(id).orElse(null);
        if (part != null) {
            part.setPartName(type);
            partRepo.save(part);
            return true;
        }
        return false;
    }
}
