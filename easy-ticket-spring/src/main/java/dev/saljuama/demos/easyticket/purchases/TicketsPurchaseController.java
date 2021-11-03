package dev.saljuama.demos.easyticket.purchases;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TicketsPurchaseController {

    private final TicketsPurchaseService service;

    @PostMapping("/tickets/buy")
    public List<TicketInformation> buyTickets(@RequestBody PurchaseRequest request) {
        return service.buyTickets(request.getShowId(), request.getAmount());
    }
}

