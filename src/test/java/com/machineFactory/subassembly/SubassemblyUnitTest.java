package com.machineFactory.subassembly;

import com.machineFactory.Model.Subassembly;
import com.machineFactory.Repository.SubassemblyRepo;
import com.machineFactory.Service.SubassemblyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SubassemblyUnitTest {

    @MockBean
    private SubassemblyRepo subassemblyRepo;

    @Autowired
    private SubassemblyService subassemblyService;

    @Test
    public void createOneSubassemblyExpectEquals1() {
        List<Subassembly> subassemblies = List.of(new Subassembly());
        when(subassemblyRepo.findAll()).thenReturn(subassemblies);

        var subassemblies1 = subassemblyService.getAllSubassemblies();
        assert subassemblies1.size() == 1;
    }

    @Test
    public void getAllSubassemblies() {
        List<Subassembly> subassemblies = List.of(new Subassembly("Tire"));
        when(subassemblyRepo.findAll()).thenReturn(subassemblies);

        List<Subassembly> listOfSubassemblies = subassemblyService.getAllSubassemblies();

        assertThat(listOfSubassemblies.size()).isEqualTo(1);
        assertThat(listOfSubassemblies.get(0).getSubassemblyName()).isEqualTo("Tire");
    }
}