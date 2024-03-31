package github.com.lucaseoliveira.desafiobackcb.application.core.domain;

import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.InvalidFieldExpection;
import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.RequiredFieldException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SellerTests {

    @Test
    void createSuccessSeller() throws Exception {
        Seller seller = new Seller(1L, "reg1", "name1", null,"123","a@a.com","CLT",
                new Branch(1L));
        boolean isValid = seller.validate();
        assertTrue(isValid);
    }

    @Test
    void createSuccessSellerWithoutRegistration() throws Exception {
        Seller seller = new Seller(1L, null, "name1", null,"123","a@a.com","CLT",
                new Branch(1L));
        assertThrows(RequiredFieldException.class, seller::validate);
    }

    @Test
    void createSuccessSellerWithoutName() throws Exception {
        Seller seller = new Seller(1L, "reg1", null, null,"123","a@a.com","CLT",
                new Branch(1L));
        assertThrows(RequiredFieldException.class, seller::validate);
    }

    @Test
    void createSuccessSellerWithoutCpfCnpj() throws Exception {
        Seller seller = new Seller(1L, "reg1", "name1", null,null,"a@a.com","CLT",
                new Branch(1L));
        assertThrows(RequiredFieldException.class, seller::validate);
    }

    @Test
    void createSuccessSellerWithoutEmail() throws Exception {
        Seller seller = new Seller(1L, "reg1", "name1", null,"123",null,"CLT",
                new Branch(1L));
        assertThrows(RequiredFieldException.class, seller::validate);
    }

    @Test
    void createSuccessSellerWithoutHiringType() throws Exception {
        Seller seller = new Seller(1L, "reg1", "name1", null,"123","a@a.com",null,
                new Branch(1L));
        assertThrows(RequiredFieldException.class, seller::validate);
    }
    

}
