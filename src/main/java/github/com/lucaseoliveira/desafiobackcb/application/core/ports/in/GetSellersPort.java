package github.com.lucaseoliveira.desafiobackcb.application.core.ports.in;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;

import java.util.List;

public interface GetSellersPort{
    List<Seller> getSellers ();
}
