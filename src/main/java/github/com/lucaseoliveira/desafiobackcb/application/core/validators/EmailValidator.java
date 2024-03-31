package github.com.lucaseoliveira.desafiobackcb.application.core.validators;

import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.InvalidFieldExpection;

public class EmailValidator implements Validator<String> {
    @Override
    public boolean validate(String item, String itemName) throws Exception {
        if(item.matches("^(.+)@(.+)$"))
        {
            return true;
        }
        throw new InvalidFieldExpection(itemName);
    }
}
