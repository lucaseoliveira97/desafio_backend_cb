package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest;

import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.GenericBranchDto;
import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.GetSellerDto;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.InvalidSellerSearchIdException;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.DeleteSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.GetSellersPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SellersController {

    GetSellersPort getSellersUseCase;
    DeleteSellerPort deleteSellerUseCase;
    public SellersController(GetSellersPort getSellersUseCase,DeleteSellerPort deleteSellerUseCase) {
        this.getSellersUseCase = getSellersUseCase;
        this.deleteSellerUseCase = deleteSellerUseCase;
    }
    @GetMapping("/sellers")
    public List<GetSellerDto> getSellers()
    {
        return getSellersUseCase.getSellers().stream().map(GetSellerDto::fromDomain).toList();
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<GetSellerDto> getSeller(@PathVariable Long sellerId)
    {
        try
        {
            return ResponseEntity.
                    ok(GetSellerDto.fromDomain(getSellersUseCase.getSeller(sellerId)));
        }
        catch (InvalidSellerSearchIdException e)
        {
            return ResponseEntity.
                    status(HttpStatus.NO_CONTENT).
                    build();
        }
    }
    @DeleteMapping("/seller/{sellerId}")
    public ResponseEntity deleteSeller(@PathVariable Long sellerId)
    {
        deleteSellerUseCase.removeSeller(sellerId);
        return ResponseEntity.ok().build();
    }
}
