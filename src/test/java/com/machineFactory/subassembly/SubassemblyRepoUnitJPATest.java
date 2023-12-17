package com.machineFactory.subassembly;
import com.machineFactory.Model.Subassembly;
import com.machineFactory.Repository.SubassemblyRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SubassemblyRepoUnitJPATest {

    @Autowired
    SubassemblyRepo subassemblyRepo;

    @Test
    void shouldFetchAllsubassemblyesExpectsEquals4(){
        List<Subassembly> subassemblies = subassemblyRepo.findAll();
        assert subassemblies.size() == 3;
    }
    @Test
    void confirmNameOnSubassembly(){
        Subassembly subassembly = subassemblyRepo.findById(2L).get();
        assertThat(subassembly.getSubassemblyName()).isEqualTo("Motor");
    }
}

//Tests from Jason repo: https://github.com/jlwcrews2/jpa-demo/blob/master/src/test/java/no/jlwcrews/jpademo/DBUnitTesting.java
