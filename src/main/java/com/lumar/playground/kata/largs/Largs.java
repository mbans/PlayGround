package com.lumar.playground.kata.largs;


//Kata Lags
//
//    About this Kata
//    This kata seems simple at first a glance, but wait to explore it before said it’s an easy one.
//
//    Problem Description
//    ABEAS Corp is a little company with only one plane. ABEAS Corp’s customers ask for this plane to help them sometimes.
//    They send rent request with start time, travel duration, and a price they will paid.
//    You could help ABEAS Corp by finding the best request combination to maximize gain.
//
//    Sample Test Cases
//    Requests are sorted. Here is a sample file with 4 requests.
//
//    AF514 0 5 10
//    CO5   3 7 14
//    AF515 5 9 7
//    BA01  6 9 8
//
//
//    The best combination here is AF514 and BA01 with a gain of 10+8=18.
//    Depending on how you want to turn this Kata, the output could be 18

import java.util.List;
import java.util.stream.Collectors;

public class Largs {


    public Integer optimize(List<FlightRequest> requests) {

        if(requests.isEmpty()) {
            return 0;
        }
        else if (requests.size() == 1) {
            return requests.get(0).getPrice();
        }
        else {
            //order by price;
            List<FlightRequest> ordered = requests.stream().sorted((a, b) -> b.getPrice().compareTo(a.getPrice())).collect(Collectors.toList());

            int bestPrice=0;

            //Start with the highest price
            //and add the next non-overlapping request

            //Then move onto the next request and check again and so forth
            for(int i=0; i<ordered.size(); i++) {
                int total = ordered.get(i).getPrice();

                for(int j=i+1; j<ordered.size(); j++) {

                    FlightRequest other = ordered.get(j);
                    if(!overlap(ordered.get(i), other)) {
                        total += other.getPrice();
                    }
                }

                System.out.printf("Total="+total);
                if(total > bestPrice) {
                    bestPrice=total;
                }
            }

            System.out.printf("bestPrice="+bestPrice);
            return bestPrice;

        }
    }

    private boolean overlap(FlightRequest request, FlightRequest other) {
        return request.getEndTime() >= other.getStartTime();
    }
}
