package github.com.lucaseoliveira.desafiobackcb.application.core.validators;

import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.RequiredFieldException;

public class RequiredValidator implements Validator<String> {
    @Override
    public boolean validate(String item,String itemName) throws Exception {
        if(item != null && !item.isBlank())
        {
            return true;
        }
        throw new RequiredFieldException(itemName);
    }
}
