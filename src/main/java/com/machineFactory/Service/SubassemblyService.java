package com.machineFactory.Service;

import com.machineFactory.Model.Subassembly;
import com.machineFactory.Repository.SubassemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Subassembly> getAllSubassemblysWithPagination(int pageNr) {
        return subassemblyRepo.findAll(PageRequest.of(pageNr, 5)).stream().toList();
    }

    public List<Subassembly> getAllSubassemblies() {
        return subassemblyRepo.findAll();
    }

    public Subassembly createSubassembly(Subassembly subassembly) {
        return subassemblyRepo.save(subassembly);
    }

    public void deleteSubassembly(Long id) {
        subassemblyRepo.deleteById(id);
    }

    public boolean updateSubassembly(Long id, String type) {
        Subassembly subassembly = subassemblyRepo.findById(id).orElse(null);
        if (subassembly != null) {
            subassembly.setSubassemblyName(type);
            subassemblyRepo.save(subassembly);
            return true;
        }
        return false;
    }
}
