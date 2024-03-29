package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest;

import github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto.GetSellerDto;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Branch;
import github.com.lucaseoliveira.desafiobackcb.application.core.domain.Seller;
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
public class GetSellerApiTests {
    @Autowired
    WebTestClient client;

    @MockBean
    private GetSellersUseCase getSellersUseCase;
    @Test
    void getSellersSuccess()
    {
        List<Seller> sellers = new ArrayList<Seller>();
        sellers.add(new Seller(1L,"reg1", "name1", null,"123", "a@a.com",
                "CLT",new Branch(0L, "branch 1", "123", "campinas","sp","CLT",
                true, null, null)));
        when(getSellersUseCase.getSellers()).thenReturn(sellers);
        client.get().uri("/sellers")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(GetSellerDto.class).hasSize(1)
                .value(dto -> assertThat(dto.get(0).id()).isEqualTo(1L));

    }
    void getSellersSuccessEmpty()
    {
        List<Seller> sellers = new ArrayList<Seller>();
        when(getSellersUseCase.getSellers()).thenReturn(sellers);
        client.get().uri("/sellers")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(GetSellerDto[].class)
                .value(dto -> assertThat(dto.length).isEqualTo(0));
    }
    void getSellerSuccess()
    {
        List<Seller> sellers = new ArrayList<Seller>();
        sellers.add(new Seller(1L,"reg1", "name1", null,"123", "a@a.com",
                "CLT",new Branch(0L, "branch 1", "123", "campinas","sp","CLT",
                true, null, null)));
        when(getSellersUseCase.getSellers()).thenReturn(sellers);
        client.get().uri("/seller/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(GetSellerDto.class)
                .value(dto -> assertThat(dto.id()).isEqualTo(1L));

    }
    void getSellerNotFound()
    {
        List<Seller> sellers = new ArrayList<Seller>();
        sellers.add(new Seller(1L,"reg1", "name1", null,"123", "a@a.com",
                "CLT",new Branch(0L, "branch 1", "123", "campinas","sp","CLT",
                true, null, null)));
        when(getSellersUseCase.getSellers()).thenReturn(sellers);
        client.get().uri("/seller/2")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound();
    }
}
