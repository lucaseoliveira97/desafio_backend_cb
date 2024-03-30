package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest;

import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.GetSellerDto;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Branch;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
import github.com.lucaseoliveira.desafiobackcb.application.core.exceptions.InvalidSellerSearchIdException;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.DeleteSellerUseCase;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.GetSellersUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebFluxTest
public class DeleteSellerApiTests {
    @Autowired
    WebTestClient client;
    @MockBean
    private GetSellersUseCase getSellersUseCase;
    @MockBean
    private DeleteSellerUseCase deleteSellerUseCase;
    @Test
    void deleteSellerSuccess() {
        client.delete().uri("/seller/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();

    }
}
