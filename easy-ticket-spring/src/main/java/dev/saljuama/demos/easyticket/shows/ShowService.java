package dev.saljuama.demos.easyticket.shows;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShowService {

    public ShowInformation getInfoForShow(Long id){
        // For demo purposes this dummy information is enough
        return new ShowInformation(1, LocalDateTime.now().plusHours(1));
    }
}
