package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest;

import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.CreateSellerUseCase;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.DeleteSellerUseCase;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.GetSellersUseCase;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.UpdateSellerUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
public class DeleteSellerApiTests {
    @Autowired
    WebTestClient client;
    @MockBean
    private GetSellersUseCase getSellersUseCase;
    @MockBean
    private DeleteSellerUseCase deleteSellerUseCase;
    @MockBean
    private CreateSellerUseCase createSellerUseCase;
    @MockBean
    private UpdateSellerUseCase updateSellerUseCase;
    @Test
    void deleteSellerSuccess() {
        client.delete().uri("/seller/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();

    }
}
