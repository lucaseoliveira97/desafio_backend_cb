package github.com.lucaseoliveira.desafiobackcb.application.core.exceptions;

public class InvalidFieldExpection extends Exception {
    public InvalidFieldExpection(String fieldName) {
        super("The field [" + fieldName + "] is invalid");
    }
}
