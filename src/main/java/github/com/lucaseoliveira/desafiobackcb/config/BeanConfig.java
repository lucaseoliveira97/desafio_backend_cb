package github.com.lucaseoliveira.desafiobackcb.config;

import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.integration.DeleteSellerAdapter;
import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.integration.FindSellersAdapter;
import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.integration.InsertSellerAdapter;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.CreateSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.DeleteSellerPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.GetSellersPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.CreateSellerUseCase;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.DeleteSellerUseCase;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.GetSellersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public GetSellersPort getSellersUseCasePort(FindSellersAdapter findSellersRepository) {
        return new GetSellersUseCase(findSellersRepository);
    }

    @Bean
    public DeleteSellerPort deleteSellerUseCasePort(DeleteSellerAdapter deleteSellerRepository) {
        return new DeleteSellerUseCase(deleteSellerRepository);
    }

    @Bean
    public CreateSellerPort createSellerUseCasePort(InsertSellerAdapter insertSellerRepository) {
        return new CreateSellerUseCase(insertSellerRepository);
    }
}
