package github.com.lucaseoliveira.desafiobackcb.application.core.validators;

import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.InvalidFieldExpection;

public class RegistrationValidator implements  Validator<String>{

    @Override
    public boolean validate(String item,String itemName) throws InvalidFieldExpection {
        if(item != null && item.matches("[0-9]+(-(OUT|CLT|PJ))\\b"))
        {
            return true;
        }
        throw new InvalidFieldExpection(itemName);
    }
}
