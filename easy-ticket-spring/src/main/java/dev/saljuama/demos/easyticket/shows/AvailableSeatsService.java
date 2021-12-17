package dev.saljuama.demos.easyticket.shows;

import dev.saljuama.demos.easyticket.FeatureToggles;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor //genera constructor con la var featureToggles
public class AvailableSeatsService {

    private final FeatureToggles featureToggles;

    public List<Integer> getAvailableSeats(int amount){
        if (amount < 1)
            throw new NoSeatsAvailableException();
        return featureToggles.isNewSeatFinderEnabled()
                ? newFancySeatFinderApproach(amount)
                : getRandomAvailableSeats(amount);
    }

    private List<Integer> getRandomAvailableSeats(int amount) {
        var rnd = new Random();
        return IntStream.rangeClosed(1, amount)
                .mapToObj(ticket -> rnd.nextInt())
                .map(random -> Math.abs(random) % 300)
                .collect(Collectors.toList());
    }

    private List<Integer> newFancySeatFinderApproach(int amount) {
        // This is a work in progress...
        return Collections.emptyList();
    }
}



