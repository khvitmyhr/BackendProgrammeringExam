package com.machineFactory.part;

import com.machineFactory.Model.Part;
import com.machineFactory.Repository.PartRepo;
import com.machineFactory.Service.PartService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PartUnitTestFails {

    @MockBean
    private PartRepo partRepo;

    @Autowired
    private PartService partService;

    @Test
    public void getParts() {
        List<Part> parts = List.of(new Part());
        when(partRepo.findAll()).thenReturn(parts);

        var appointments = partService.getAllPartsWithPagination(0);
        assert appointments.size() == 1;
    }

    @Test
    public void getAllParts() {
        Part part = partRepo.save(new Part("Nail"));

        Mockito.when(partService.findPartById(1L)).thenReturn(part);

        when(partRepo.save(part)).thenReturn(part);

        partService.createPart(part);
        List<Part> listOfCustomers = partService.getAllPartsWithPagination(0);

        assertThat(listOfCustomers.size()).isEqualTo(1);
        assertThat(listOfCustomers.get(0).getPartName()).isEqualTo("Nail");

    }
}

