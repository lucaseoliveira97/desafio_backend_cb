package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest;

import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.CreateSellerDto;
import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.GenericBranchDto;
import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.GenericResponseDto;
import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.GetSellerDto;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.InvalidSellerSearchIdException;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.CreateSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.DeleteSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.GetSellersPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class SellersController {

    GetSellersPort getSellersUseCase;
    DeleteSellerPort deleteSellerUseCase;
    CreateSellerPort createSellerUseCase;
    public SellersController(GetSellersPort getSellersUseCase,DeleteSellerPort deleteSellerUseCase,CreateSellerPort createSellerUseCase) {
        this.getSellersUseCase = getSellersUseCase;
        this.deleteSellerUseCase = deleteSellerUseCase;
        this.createSellerUseCase = createSellerUseCase;
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
        return ResponseEntity.ok().body(new GenericResponseDto(HttpStatus.OK.name()));
    }
    @PostMapping("/seller")
    public ResponseEntity createSeller(@RequestBody CreateSellerDto seller)
    {
        UUID taskId = createSellerUseCase.createSeller(CreateSellerDto.toDomain(seller));
        return ResponseEntity.status(HttpStatus.CREATED)
                .header(HttpHeaders.LOCATION, "/status/" + taskId.toString())
                .body(new GenericResponseDto(HttpStatus.CREATED.name()));
    }
    @GetMapping("/status/{taskId}")
    public ResponseEntity getCreateSellerStatus(@PathVariable UUID taskId)
    {
        return ResponseEntity.ok().body(this.createSellerUseCase.getCreateSellerStatus(taskId));
    }
}
