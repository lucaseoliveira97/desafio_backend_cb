package github.com.lucaseoliveira.desafiobackcb.application.core.domain;

import java.util.UUID;

public class SellerTask {
    private UUID id;
    private Seller seller;
    private TaskStatus status;
    private String message;
    public enum TaskStatus {
        STARTED,
        COMPLETED,
        ERROR
    }
    public SellerTask(UUID id, Seller seller, TaskStatus status, String message)
    {
        this.id = id;
        this.seller = seller;
        this.status=status;
        this.message=message;
    }
    public SellerTask(UUID id, Seller seller, TaskStatus status)
    {
        this(id, seller, status, "");
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
