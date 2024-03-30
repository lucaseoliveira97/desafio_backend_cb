package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest;

import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.CreateSellerDto;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.CreateSellerUseCase;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.DeleteSellerUseCase;
import github.com.lucaseoliveira.desafiobackcb.application.core.usecase.in.GetSellersUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

@WebFluxTest
public class CreateSellerApiTests {
    @Autowired
    WebTestClient client;
    @MockBean
    private GetSellersUseCase getSellersUseCase;
    @MockBean
    private DeleteSellerUseCase deleteSellerUseCase;
    @MockBean
    private CreateSellerUseCase createSellerUseCase;
    @Test
    public void createSellerSuccess()
    {
        CreateSellerDto createSellerDto = new CreateSellerDto("reg", "name",
                LocalDate.now(), "12312312312", "a@a.com","CLT", null);
        client.post().uri("/seller")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(createSellerDto)
                .exchange()
                .expectStatus().isOk();
    }
}
