package github.com.lucaseoliveira.desafiobackcb.application.core.domain;

import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.RequiredFieldException;
import github.com.lucaseoliveira.desafiobackcb.application.core.validators.HiringTypeValidator;
import github.com.lucaseoliveira.desafiobackcb.application.core.validators.RegistrationValidator;
import github.com.lucaseoliveira.desafiobackcb.application.core.validators.RequiredValidator;
import github.com.lucaseoliveira.desafiobackcb.application.core.validators.Validator;

import java.time.LocalDate;


public record Seller(Long id,
                     String registration,
                     String name,
                     LocalDate birthDate,
                     String cpfCnpj,
                     String email,
                     String hiringType,
                     Branch branch) {
    public boolean validate() throws Exception {

        RegistrationValidator registrationValidator = new RegistrationValidator();
        RequiredValidator requiredValidator = new RequiredValidator();
        HiringTypeValidator hiringTypeValidator = new HiringTypeValidator();
        requiredValidator.validate(this.registration, "registration");
        requiredValidator.validate(this.name, "name");
        requiredValidator.validate(this.cpfCnpj, "cpfCnpj");
        requiredValidator.validate(this.email, "email");
        requiredValidator.validate(this.hiringType, "hiringType");

        registrationValidator.validate(this.registration, "registration");
        hiringTypeValidator.validate(this.hiringType, "hiringType");
        return true;

    }
}