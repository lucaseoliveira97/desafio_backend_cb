package github.com.lucaseoliveira.desafiobackcb.application.core.domain;

import java.util.UUID;

public record SellerTask(UUID id, Seller seller, TaskStatus status) {


    public enum TaskStatus {
        STARTED
    }
}
