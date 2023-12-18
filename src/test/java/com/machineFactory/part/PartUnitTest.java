package com.machineFactory.part;

import com.machineFactory.Model.Part;
import com.machineFactory.Repository.PartRepo;
import com.machineFactory.Service.PartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PartUnitTest {

    @MockBean
    private PartRepo partRepo;

    @Autowired
    private PartService partService;

    @Test
    public void createOnePartExpectEquals1() {
        List<Part> parts = List.of(new Part());
        when(partRepo.findAll()).thenReturn(parts);

        var parts1 = partService.getAllParts();
        assert parts1.size() == 1;
    }

    @Test
    public void getAllPartsAndConfirmCorrectName() {
        List<Part> parts = List.of(new Part("Nail"));
        when(partRepo.findAll()).thenReturn(parts);

        List<Part> listOfParts = partService.getAllParts();

        assertThat(listOfParts.size()).isEqualTo(1);
        assertThat(listOfParts.get(0).getPartName()).isEqualTo("Nail");
    }
}
