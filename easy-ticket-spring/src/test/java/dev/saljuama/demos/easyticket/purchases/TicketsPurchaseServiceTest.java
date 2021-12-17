package dev.saljuama.demos.easyticket.purchases;

import dev.saljuama.demos.easyticket.FeatureToggles;
import dev.saljuama.demos.easyticket.shows.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketsPurchaseServiceTest {

    @Mock
    private ShowService showService;
    @Mock
    private AvailableSeatsService availableSeatsService;

    @InjectMocks //en la clase que queremos inyectar los mocks de arriba
    private TicketsPurchaseService service;


    @Test
    void returnTwoTicketsSoldAndShow() {
        when(availableSeatsService.getAvailableSeats(2)).thenReturn(Arrays.asList(3, 5));
        when(showService.getInfoForShow(1L)).thenReturn(new ShowInformation(1, LocalDateTime.now().plusHours(1)));

        var ticketsSold = service.buyTickets(1L, 2);

        assertThat(ticketsSold.size()).isEqualTo(2);

    }

    @Test
    void returnZeroTicketsWhenShowDoesNotExist() {
       doThrow(new ShowDoesNotExistException()).when(showService).getInfoForShow(2L);

       assertThatThrownBy(() -> service.buyTickets(2L, 2))
               .hasMessage("what show you asking for? huh?");

    }

    @Test
    void returnZeroTicketsWhenIsSoldOut() {
        doThrow(NoSeatsAvailableException.class).when(availableSeatsService).getAvailableSeats(2);
        when(showService.getInfoForShow(1L)).thenReturn(new ShowInformation(1, LocalDateTime.now().plusHours(1)));

        assertThatThrownBy(() -> service.buyTickets(2L, 2))
                .hasMessage("yo, no seats available!");
    }

}