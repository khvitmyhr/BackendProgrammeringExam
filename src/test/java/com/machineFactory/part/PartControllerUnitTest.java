package com.machineFactory.part;

import com.machineFactory.Controller.PartController;
import com.machineFactory.Repository.PartRepo;
import com.machineFactory.Service.PartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
@SpringBootTest
public class PartControllerUnitTest {

    @MockBean
    private PartRepo partRepo;

    @Autowired
    private PartController partController;

    @Autowired
    private PartService partService;

}
