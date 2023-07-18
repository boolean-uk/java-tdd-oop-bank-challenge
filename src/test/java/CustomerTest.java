import com.booleanuk.core.CurrentAccount;
import com.booleanuk.core.Customer;
import com.booleanuk.core.SavingsAccount;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    void beforeEach() {
        customer = new Customer("John Doe","69213123441234","str. test address");
    }

    @Test
    public void testCreateSavingsAccount(){
        Assertions.assertEquals(0,customer.getAccounts().size());
        Assertions.assertEquals("accountNumber123",customer.createSavingsAccount("accountNumber123").getAccountNumber());
        Assertions.assertEquals(1,customer.getAccounts().size());
        Assertions.assertEquals("accountNumber123",customer.getAccounts().get("accountNumber123").getAccountNumber());


    }
    @Test
    public void testCreateCurrentAccount(){
        //customer = new Customer("")
        Assertions.assertEquals(0,customer.getAccounts().size());
        Assertions.assertEquals("currentAccount123",customer.createCurrentAccount("currentAccount123").getAccountNumber());
        Assertions.assertEquals(1,customer.getAccounts().size());
        Assertions.assertEquals("currentAccount123",customer.getAccounts().get("currentAccount123").getAccountNumber());

    }
}
