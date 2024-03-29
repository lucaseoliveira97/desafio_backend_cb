package github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.InvalidSellerSearchIdException;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.GetSellersPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.out.FindSellersPort;

import java.util.List;

public class GetSellersUseCase implements GetSellersPort {

    private final FindSellersPort findSellersRepository;

    public GetSellersUseCase(FindSellersPort findSellersRepository) {
        this.findSellersRepository = findSellersRepository;
    }
    @Override
    public List<Seller> getSellers() {

        return findSellersRepository.findSellers();
    }

    @Override
    public Seller getSeller(Long id) throws InvalidSellerSearchIdException {
        return findSellersRepository.findSeller(id).orElseThrow(() -> new InvalidSellerSearchIdException(id));
    }
}
