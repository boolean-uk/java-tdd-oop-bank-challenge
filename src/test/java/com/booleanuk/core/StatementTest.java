package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatementTest {

    Account myAccount = new CurrentAccount();
    Statement myStatement = new Statement(myAccount);

    @Test
    public void testStatement() {
        Assertions.assertNotNull(myStatement);
    }

}
