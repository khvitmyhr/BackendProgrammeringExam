package com.machineFactory.Service;

import com.machineFactory.Model.Address;
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

    public List<Subassembly> getAllSubassemblysWithPagination(int pageNumber) {
        return subassemblyRepo.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }
    public Subassembly createSubassembly(Subassembly subassembly) {
        return subassemblyRepo.save(subassembly);
    }

    public void deleteSubassembly(Long id) {
        subassemblyRepo.deleteById(id);
    }

}
