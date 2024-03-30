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
import java.util.UUID;

import static org.mockito.Mockito.when;

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
        UUID id = UUID.randomUUID();
        when(createSellerUseCase.createSeller(CreateSellerDto.toDomain(createSellerDto))).thenReturn(id);
        client.post().uri("/seller")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(createSellerDto)
                .exchange()
                .expectHeader().location("/status/"+id.toString())
                .expectStatus().isCreated();
    }
}
