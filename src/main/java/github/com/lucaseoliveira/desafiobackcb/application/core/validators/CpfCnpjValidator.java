package github.com.lucaseoliveira.desafiobackcb.application.core.validators;

import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.InvalidFieldExpection;

public class CpfCnpjValidator implements  Validator<String>{
    private final int[] CpfWeight = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private final int[] CnpjWeight = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    @Override
    public boolean validate(String item, String itemName) throws Exception {
        if(isValid(item))
        {
            return true;
        }
        throw new InvalidFieldExpection(itemName);
    }

    public boolean isValid(String cpfCnpj) {
        return (isValidCPF(cpfCnpj) || isValidCNPJ(cpfCnpj));
    }

    private int calculateDigit(String str, int[] weight) {
        int sum = 0;
        for (int index=str.length()-1, digit; index >= 0; index-- ) {
            digit = Integer.parseInt(str.substring(index,index+1));
            sum += digit*weight[weight.length-str.length()+index];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

    private String padLeft(String text, char character) {
        return String.format("%11s", text).replace(' ', character);
    }

    private boolean isValidCPF(String cpf) {
        cpf = cpf.trim().replace(".", "").replace("-", "");
        if (cpf == null || (cpf.length()!=11) || !cpf.matches("[0-9]+")) return false;

        for (int j = 0; j < 10; j++)
            if (padLeft(Integer.toString(j), Character.forDigit(j, 10)).equals(cpf))
                return false;

        Integer digito1 = calculateDigit(cpf.substring(0,9), CpfWeight);
        Integer digito2 = calculateDigit(cpf.substring(0,9) + digito1, CpfWeight);
        return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
    }

    public boolean isValidCNPJ(String cnpj) {
        cnpj = cnpj.trim().replace(".", "").replace("-", "").replace("/", "");
        if ((cnpj == null)||(cnpj.length()!=14) || !cnpj.matches("[0-9]+")) return false;

        Integer digit1 = calculateDigit(cnpj.substring(0,12), CnpjWeight);
        Integer digit2 = calculateDigit(cnpj.substring(0,12) + digit1, CnpjWeight);
        return cnpj.equals(cnpj.substring(0,12) + digit1.toString() + digit2.toString());
    }
}
