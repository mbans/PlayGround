package com.lumar.playground.kata.largs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LargsTest {

    private Largs largs = new Largs();

    @Test
    public void shouldCreateApp() {
        largs = new Largs();
    }

    @Test
    public void canAcceptEmptyRequest() {
        List<FlightRequest> requests = new ArrayList<>();
        assertThat(largs.optimize(requests), is(0));
    }

    @Test
    public void oneRequest() {
        List<FlightRequest> requests = new ArrayList<>();
        FlightRequest baRequest = new FlightRequest("BA1234",0,2,100);
        requests.add(baRequest);
        assertThat(largs.optimize(requests), is(100));
    }

    @Test
    public void choosePriceWhenNoOverlapping() {
        List<FlightRequest> requests = new ArrayList<>();
        requests.add(new FlightRequest("A", 0, 5, 10));
        requests.add(new FlightRequest("B", 3, 7, 14));
        requests.add(new FlightRequest("C", 5, 9, 7));
        requests.add(new FlightRequest("D", 6, 9, 8));
        requests.add(new FlightRequest("D", 10, 12, 3));
        assertThat(largs.optimize(requests), is(21));
    }

    @Test
    public void chooseHighestWhenOverlapping() {
        List<FlightRequest> requests = new ArrayList<>();
        FlightRequest request1 = new FlightRequest("A", 0, 2, 100);
        FlightRequest request2 = new FlightRequest("B", 1, 5, 200);

        requests.add(request1);
        requests.add(request2);

        assertThat(largs.optimize(requests), is(200));

    }

}
