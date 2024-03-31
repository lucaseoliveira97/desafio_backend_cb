package github.com.lucaseoliveira.desafiobackcb.application.core.validators;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.HiringType;
import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.InvalidFieldExpection;

public class HiringTypeValidator implements Validator<String> {
    @Override
    public boolean validate(String item, String itemName) throws Exception {
        String normalizedItem = item.replace(" ", "_").toUpperCase();
        for (HiringType c : HiringType.values()) {
            if (c.name().equals(normalizedItem)) {
                return true;
            }
        }
        throw new InvalidFieldExpection(itemName);
    }
}
