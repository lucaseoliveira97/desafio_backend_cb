package github.com.lucaseoliveira.desafiobackcb.application.core.domain;

import github.com.lucaseoliveira.desafiobackcb.application.core.validators.*;

import java.time.LocalDate;
import java.util.HashMap;


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
        CpfCnpjValidator cpfCnpjValidator = new CpfCnpjValidator();
        EmailValidator emailValidator = new EmailValidator();
        CpfCnjpHiringTypeValidator cpfCnjpHiringTypeValidator = new CpfCnjpHiringTypeValidator();

        requiredValidator.validate(this.registration, "registration");
        requiredValidator.validate(this.name, "name");
        requiredValidator.validate(this.cpfCnpj, "cpfCnpj");
        requiredValidator.validate(this.email, "email");
        requiredValidator.validate(this.hiringType, "hiringType");

        registrationValidator.validate(this.registration, "registration");
        hiringTypeValidator.validate(this.hiringType, "hiringType");
        cpfCnpjValidator.validate(this.cpfCnpj,"cpfCnpj");
        emailValidator.validate(this.email, "email");

        HashMap<String,String> hiringTypeCpfCnpj = new HashMap<>();
        hiringTypeCpfCnpj.put("hiringType", this.hiringType);
        hiringTypeCpfCnpj.put("cpfCnpj", this.cpfCnpj);
        cpfCnjpHiringTypeValidator.validate(hiringTypeCpfCnpj,"hiringType");


        return true;

    }
}