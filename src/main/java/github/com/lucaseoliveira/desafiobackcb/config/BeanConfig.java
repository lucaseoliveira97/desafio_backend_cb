package github.com.lucaseoliveira.desafiobackcb.config;

import github.com.lucaseoliveira.desafiobackcb.adapter.out.persistence.integration.FindSellersAdapter;
import github.com.lucaseoliveira.desafiobackcb.application.core.ports.in.GetSellersPort;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.GetSellersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public GetSellersPort getSellersUseCasePort(FindSellersAdapter findSellersRepository) {
        return new GetSellersUseCase(findSellersRepository);
    }
}
