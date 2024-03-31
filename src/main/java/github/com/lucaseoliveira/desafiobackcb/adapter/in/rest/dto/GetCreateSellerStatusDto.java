package github.com.lucaseoliveira.desafiobackcb.adapter.in.rest.dto;

import github.com.lucaseoliveira.desafiobackcb.application.core.domain.SellerTask;

import java.util.UUID;

public record GetCreateSellerStatusDto(SellerTask.TaskStatus status, String message, UUID id, Long sellerId) {
    public static GetCreateSellerStatusDto fromDomain(SellerTask sellerTask)
    {
        return new GetCreateSellerStatusDto(sellerTask.getStatus(),sellerTask.getMessage(), sellerTask.getId(),sellerTask.getSeller().id());
    }
}
