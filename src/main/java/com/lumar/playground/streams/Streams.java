package com.lumar.playground.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by lumarmacy1 on 12/10/2017.
 */
public class Streams {


    public static void main(String[] args) {
        streamWithReduce();
        sort(values(3000000), true);
        sort(values(3000000), false);
    }

    public static void streamWithReduce() {
        Optional<String> reduced = ccys()
                .stream()
                .sorted()
                .reduce((a, b) -> a + "," + b);
    }

    public static void sort(List<String> values, boolean isParallel) {
        long t0 = System.nanoTime();

        if(isParallel) {
            values.parallelStream().sorted().count();
        }
        else {
            values.stream().sorted().count();
        }

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format((isParallel ? "Parallel " : "Sequential ") + "sort took: %d ms", millis));
    }

    private static List<String> values(int max) {
        List<String> values = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        return values;
    }


    public static List<String> ccys() {
        List<String> ccy = new ArrayList<>();
        ccy.add("GBP");
        ccy.add("USD");
        ccy.add("EUR");
        return ccy;
    }

}
