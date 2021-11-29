package dev.saljuama.demos.easyticket.purchases;

import dev.saljuama.demos.easyticket.FeatureToggles;
import dev.saljuama.demos.easyticket.shows.AvailableSeatsService;
import dev.saljuama.demos.easyticket.shows.ShowService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketsPurchaseServiceTest {

    @Mock
    private ShowService showService;
    @Mock
    private AvailableSeatsService availableSeatsService;
    @Mock
    private FeatureToggles featureToggles;

    private TicketsPurchaseService service;


    @BeforeEach
    void setUp() {
        service = new TicketsPurchaseService(showService, availableSeatsService, featureToggles);
    }

    @Test
    void buyTickets_whenNewSeatsFinderIsNotEnabled_returnRandomSeats() {
        when(featureToggles.isNewSeatFinderEnabled()).thenReturn(false);
        when(availableSeatsService.getRandomAvailableSeats(4))
                .thenReturn(Arrays.asList(0, 12, 24, -23));

        var ticketsSold = service.buyTickets(1L, 4);

        // assert whatever

    }

    @Test
    void buyTickets_whenNewSeatsFinderIsEnabled_returnSitsNextToEachOther() {
        when(featureToggles.isNewSeatFinderEnabled()).thenReturn(true);
        when(availableSeatsService.newFancySeatFinderApproach(4))
                .thenReturn(Arrays.asList(3,4,5,6));

        var ticketsSold = service.buyTickets(1L, 4);
    }
}