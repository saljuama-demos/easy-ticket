package dev.saljuama.demos.easyticket.purchases;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketInformation {
    private final int room;
    private final int seat;
    private final LocalDateTime startingTime;
}
