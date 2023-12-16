package com.machineFactory.part;
import com.machineFactory.Model.Part;
import com.machineFactory.Repository.PartRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class PartRepoUnitJPATest {

    @Autowired
    PartRepo partRepo;
    @Test
    void shouldFetchAllPartsExpectsEquals4(){
        List<Part> parts = partRepo.findAll();
        assert parts.size() == 4;
    }

    @Test
    void confirmNameOnPart(){
        Part part = partRepo.findById(2L).get();
        assert part.getPartName().equals("Piston");
    }
}

//Test from Jason repo: https://github.com/jlwcrews2/jpa-demo/blob/master/src/test/java/no/jlwcrews/jpademo/DBUnitTesting.java
