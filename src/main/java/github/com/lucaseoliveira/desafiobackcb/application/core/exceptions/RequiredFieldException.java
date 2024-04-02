package github.com.lucaseoliveira.desafiobackcb.application.core.exceptions;

public class RequiredFieldException  extends Exception {
    public RequiredFieldException(String fieldName) {
        super("The field [" + fieldName + "] is required");
    }
}
