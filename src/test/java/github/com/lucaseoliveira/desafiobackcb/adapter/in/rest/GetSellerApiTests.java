package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
public class GetSellerApiTests {
    @Autowired
    WebTestClient client;

    @Test
    void getSellersSuccess()
    {
        client.get().uri("/sellers")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }
}
