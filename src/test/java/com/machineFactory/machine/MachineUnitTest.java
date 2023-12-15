package com.machineFactory.machine;

import com.machineFactory.Model.Machine;
import com.machineFactory.Model.Subassembly;
import com.machineFactory.Repository.MachineRepo;
import com.machineFactory.Service.MachineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MachineUnitTest {

    @MockBean
    MachineRepo machineRepo;

    @Autowired
    MachineService machineService;

    @Test
    public void shouldreturnTractorFromMockedRepo() {

        ArrayList<Subassembly> sub = new ArrayList<>();

        List<Machine> machines = List.of(new Machine("Tractor", sub));
        when(machineRepo.findAll()).thenReturn(machines);

        List<Machine> listOfMachines = machineService.getAllMachines();

        assertThat(listOfMachines.size()).isEqualTo(1);
        assertThat(listOfMachines.get(0).getMachineName()).isEqualTo("Tractor");
    }
}