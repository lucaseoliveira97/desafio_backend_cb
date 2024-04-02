package github.com.lucaseoliveira.desafiobackcb.application.core.validators;


public interface Validator<T> {
    public boolean validate(T item, String itemName) throws Exception;
}
