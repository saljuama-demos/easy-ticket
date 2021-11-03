package dev.saljuama.demos.easyticket.shows;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AvailableSeatsService {

    public List<Integer> getRandomAvailableSeats(int amount) {
        var rnd = new Random();
        return IntStream.rangeClosed(1, amount)
                .mapToObj( ticket -> rnd.nextInt())
                .map(random -> Math.abs(random) % 300)
                .collect(Collectors.toList());
    }
}
