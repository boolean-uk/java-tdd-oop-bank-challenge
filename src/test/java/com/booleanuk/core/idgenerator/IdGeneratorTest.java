package com.booleanuk.core.idgenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IdGeneratorTest {

    @Test
    public void generateMultipleUniqueIds() {
        Assertions.assertEquals("AC_1", new IdGenerator(IdPrefix.AC).getId());
        Assertions.assertEquals("AC_2", new IdGenerator(IdPrefix.AC).getId());
        Assertions.assertEquals("AC_3", new IdGenerator(IdPrefix.AC).getId());

        Assertions.assertEquals("RE_1", new IdGenerator(IdPrefix.RE).getId());
        Assertions.assertEquals("RE_2", new IdGenerator(IdPrefix.RE).getId());
        Assertions.assertEquals("RE_3", new IdGenerator(IdPrefix.RE).getId());

        Assertions.assertEquals("TR_1", new IdGenerator(IdPrefix.TR).getId());
        Assertions.assertEquals("TR_2", new IdGenerator(IdPrefix.TR).getId());
        Assertions.assertEquals("TR_3", new IdGenerator(IdPrefix.TR).getId());

        Assertions.assertEquals("AC_4", new IdGenerator(IdPrefix.AC).getId());
        Assertions.assertEquals("RE_4", new IdGenerator(IdPrefix.RE).getId());
        Assertions.assertEquals("TR_4", new IdGenerator(IdPrefix.TR).getId());
    }
}
