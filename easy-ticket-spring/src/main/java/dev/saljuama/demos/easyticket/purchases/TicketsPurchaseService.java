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
        /*
        This is the simplest and easiest way to toggle functionality,
        this can be used while in development, and only enable it once it
        is ready to be shipped.

        Although, this approach has some problems, can you try to guess which ones?
         */
        var useNewSeatFindingAlgorithm = false;

        var showInformation = showService.getInfoForShow(showId);
        var availableSeats = useNewSeatFindingAlgorithm
                ? availableSeatsService.newFancySeatFinderApproach(amount)
                : availableSeatsService.getRandomAvailableSeats(amount);

        return availableSeats
                .stream()
                .map(seat -> new TicketInformation(showInformation.getRoom(), seat, showInformation.getStartTime()))
                .collect(Collectors.toList());
    }

}
