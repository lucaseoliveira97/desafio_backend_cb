package github.com.lucaseoliveira.desafiobackcb.application.core.exceptions;

public class CpfCnjpHiringTypeInconsistencyExpection extends Exception {
    public CpfCnjpHiringTypeInconsistencyExpection() {
        super("Sellers with PJ hiring type should use the CNPJ document and other should use the CPF document");
    }
}
