package dev.saljuama.demos.easyticket.shows;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShowInformation {
    private final int room;
    private final LocalDateTime startTime;
}
