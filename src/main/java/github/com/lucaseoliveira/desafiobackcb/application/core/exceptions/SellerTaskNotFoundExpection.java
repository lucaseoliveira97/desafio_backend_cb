package github.com.lucaseoliveira.desafiobackcb.application.core.exceptions;

import java.util.UUID;

public class SellerTaskNotFoundExpection extends Exception{
    public SellerTaskNotFoundExpection(UUID id)
    {
        super("Seller task ["+ id.toString() + "] not found");
    }
}
