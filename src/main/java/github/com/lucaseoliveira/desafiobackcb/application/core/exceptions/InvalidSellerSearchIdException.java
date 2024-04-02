package github.com.lucaseoliveira.desafiobackcb.application.core.exceptions;

public class InvalidSellerSearchIdException extends Exception {
    public InvalidSellerSearchIdException(Long sellerId) {
        super("There is no seller with [" + sellerId + "] id");
    }
}