package dev.saljuama.demos.easyticket.purchases;

import dev.saljuama.demos.easyticket.shows.AvailableSeatsService;
import dev.saljuama.demos.easyticket.shows.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TicketsPurchaseService {

    private final ShowService showService;
    private final AvailableSeatsService availableSeatsService;

    public List<TicketInformation> buyTickets(Long showId, int amount) {
        var showInformation = showService.getInfoForShow(showId);
        return availableSeatsService
                .getRandomAvailableSeats(amount)
                .stream()
                .map(seat -> new TicketInformation(showInformation.getRoom(), seat, showInformation.getStartTime()))
                .collect(Collectors.toList());
    }

}