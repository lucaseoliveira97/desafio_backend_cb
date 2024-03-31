package github.com.lucaseoliveira.desafiobackcb.application.core.domain;

import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.InvalidFieldExpection;
import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.RequiredFieldException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

public class SellerTests {

    @Test
    void createSuccessSeller() throws Exception {
        Seller seller = new Seller(1L, "98767367-OUT", "name1", null,"123","a@a.com","CLT",
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
        Seller seller = new Seller(1L, "98767367-OUT", null, null,"123","a@a.com","CLT",
                new Branch(1L));
        assertThrows(RequiredFieldException.class, seller::validate);
    }

    @Test
    void createSuccessSellerWithoutCpfCnpj() throws Exception {
        Seller seller = new Seller(1L, "98767367-OUT", "name1", null,null,"a@a.com","CLT",
                new Branch(1L));
        assertThrows(RequiredFieldException.class, seller::validate);
    }

    @Test
    void createSuccessSellerWithoutEmail() throws Exception {
        Seller seller = new Seller(1L, "98767367-OUT", "name1", null,"123",null,"CLT",
                new Branch(1L));
        assertThrows(RequiredFieldException.class, seller::validate);
    }

    @Test
    void createSuccessSellerWithoutHiringType() throws Exception {
        Seller seller = new Seller(1L, "98767367-OUT", "name1", null,"123","a@a.com",null,
                new Branch(1L));
        assertThrows(RequiredFieldException.class, seller::validate);
    }
    @Test
    void createSuccessSellerRegistrationOut() throws Exception {
        Seller seller = new Seller(1L, "98767367-OUT", "name1", null,"123","a@a.com","CLT",
                new Branch(1L));
        boolean isValid = seller.validate();
        assertTrue(isValid);
    }
    @Test
    void createSuccessSellerRegistrationClt() throws Exception {
        Seller seller = new Seller(1L, "98767367-CLT", "name1", null,"123","a@a.com","CLT",
                new Branch(1L));
        boolean isValid = seller.validate();
        assertTrue(isValid);
    }
    @Test
    void createSuccessSellerRegistrationPj() throws Exception {
        Seller seller = new Seller(1L, "98767367-PJ", "name1", null,"123","a@a.com","CLT",
                new Branch(1L));
        boolean isValid = seller.validate();
        assertTrue(isValid);
    }

    @Test
    void createSuccessSellerRegistrationWithLetters() throws Exception {
        Seller seller = new Seller(1L, "9A767367-PJ", "name1", null,"123","a@a.com","CLT",
                new Branch(1L));
        assertThrows(InvalidFieldExpection.class, seller::validate);
    }

    @Test
    void createSuccessSellerRegistrationWithAnotherTermination() throws Exception {
        Seller seller = new Seller(1L, "93767367-AC", "name1", null,"123","a@a.com","CLT",
                new Branch(1L));
        assertThrows(InvalidFieldExpection.class, seller::validate);
    }

    @Test
    void createSuccessSellerRegistrationWithInvalidDate() throws Exception {

        assertThrows(DateTimeParseException.class, ()->{
            Seller seller = new Seller(1L, "93767367-AC", "name1", LocalDate.parse("10/10/2023"),"123","a@a.com","CLT",
                    new Branch(1L));
        });
    }

    @Test
    void createSuccessSellerRegistrationWithErrorHiringType() throws Exception {
        Seller seller = new Seller(1L, "93767367-AC", "name1", null,"123","a@a.com","tipo",
                new Branch(1L));
        assertThrows(InvalidFieldExpection.class, seller::validate);
    }
    @Test
    void createSuccessSellerHiringTypeOut() throws Exception {
        Seller seller = new Seller(1L, "98767367-PJ", "name1", null,"123","a@a.com","Outsourcing",
                new Branch(1L));
        boolean isValid = seller.validate();
        assertTrue(isValid);
    }
    @Test
    void createSuccessSellerHiringTypePj() throws Exception {
        Seller seller = new Seller(1L, "98767367-PJ", "name1", null,"123","a@a.com","Pessoa Juridica",
                new Branch(1L));
        boolean isValid = seller.validate();
        assertTrue(isValid);
    }
    @Test
    void createSuccessSellerHiringTypeClt() throws Exception {
        Seller seller = new Seller(1L, "98767367-PJ", "name1", null,"123","a@a.com","CLT",
                new Branch(1L));
        boolean isValid = seller.validate();
        assertTrue(isValid);
    }
}
