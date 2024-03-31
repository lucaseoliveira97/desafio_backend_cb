package github.com.lucaseoliveira.desafiobackcb.application.core.validators;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.HiringType;
import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.CpfCnjpHiringTypeInconsistencyExpection;

import java.util.HashMap;


public class CpfCnjpHiringTypeValidator implements Validator<HashMap<String, String>>{
    @Override
    public boolean validate(HashMap<String,String > item, String itemName) throws Exception {
        String normalizedItem = item.get("hiringType").replace(" ", "_").toUpperCase();
        if(HiringType.PESSOA_JURIDICA.name().equals(normalizedItem))
        {
            String cnpj = item.get("cpfCnpj");
            cnpj = cnpj.trim().replace(".", "").replace("-", "").replace("/", "");
            if(cnpj.matches("[0-9]+") && cnpj.length() == 14)
            {
                return true;
            }
            throw new CpfCnjpHiringTypeInconsistencyExpection();
        }
        else
        {
            String cpf = item.get("cpfCnpj");
            cpf = cpf.trim().replace(".", "").replace("-", "");
            if(cpf.matches("[0-9]+") && cpf.length() == 11)
            {
                return true;
            }
        }
        throw new CpfCnjpHiringTypeInconsistencyExpection();

    }
}
