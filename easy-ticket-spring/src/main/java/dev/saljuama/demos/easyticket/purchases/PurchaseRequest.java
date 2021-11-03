package dev.saljuama.demos.easyticket.purchases;

import lombok.Data;

@Data
public class PurchaseRequest {
    private final Long showId;
    private final int amount;
}
