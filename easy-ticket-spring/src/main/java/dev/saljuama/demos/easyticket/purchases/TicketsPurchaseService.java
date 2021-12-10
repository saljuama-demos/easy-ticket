package dev.saljuama.demos.easyticket.purchases;

import dev.saljuama.demos.easyticket.FeatureToggles;
import dev.saljuama.demos.easyticket.shows.AvailableSeatsService;
import dev.saljuama.demos.easyticket.shows.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TicketsPurchaseService {

    private final ShowService showService;
    private final AvailableSeatsService availableSeatsService;

    public List<TicketInformation> buyTickets(Long showId, int amount) {
        try {
            var showInformation = showService.getInfoForShow(showId);
            var availableSeats = availableSeatsService.getAvailableSeats(amount);

            return availableSeats
                    .stream()
                    .map(seat -> new TicketInformation(showInformation.getRoom(), seat, showInformation.getStartTime()))
                    .collect(Collectors.toList());
        }catch (RuntimeException e){
            return new ArrayList<>(); //esto es una lista vacía, estamos haciendo referencia a list<TicketInformation>, no se ha ejecutado dentro del try
        }
    }

}
