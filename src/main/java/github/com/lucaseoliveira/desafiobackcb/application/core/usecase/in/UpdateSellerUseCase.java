package github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.UpdateSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.out.UpdateSellerOutPort;

public class UpdateSellerUseCase implements UpdateSellerPort {
    private final UpdateSellerOutPort updateSellerAdaper;


    public UpdateSellerUseCase(UpdateSellerOutPort updateSellerAdaper) {
        this.updateSellerAdaper = updateSellerAdaper;
    }

    @Override
    public Seller updateSeller(Long id, Seller seller) throws Exception {
        if(seller.validate())
        {
            return updateSellerAdaper.updateSeller(id, seller);
        }
        return null;

    }
}
