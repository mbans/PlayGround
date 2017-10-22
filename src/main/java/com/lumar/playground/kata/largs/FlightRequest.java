package com.lumar.playground.kata.largs;

public class FlightRequest {

    private String flight;
    private Integer startTime;
    private Integer endTime;
    private Integer price;

    public FlightRequest(String flight, int startTime, int endTime, int price) {
        this.flight = flight;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FlightRequest{" +
                "flight='" + flight + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                '}';
    }
}
