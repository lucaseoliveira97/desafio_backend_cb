package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest;

import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.GenericBranchDto;
import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.GetSellerDto;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.GetSellersPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SellersController {

    GetSellersPort getSellersUseCase;
    public SellersController(GetSellersPort getSellersUseCase) {
        this.getSellersUseCase = getSellersUseCase;
    }
    @GetMapping("/sellers")
    List<GetSellerDto> getSellers()
    {
        List<GetSellerDto> sellers = new ArrayList<GetSellerDto>();
        return getSellersUseCase.getSellers().stream().map(seller ->
                new GetSellerDto(seller.id(),seller.registration(),seller.name(),seller.birthDate(), seller.cpfCnpj(),seller.email(), seller.hiringType(),
                        new GenericBranchDto(seller.branch().id(),seller.branch().name(), seller.branch().cnpj(), seller.branch().city(),seller.branch().uf(),
                                seller.branch().type(), seller.branch().active(), seller.branch().registrationDate(),
                                seller.branch().lastUpdate()))).toList();
    }
}
