package com.lumar.playground.goldmansachs;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Goldman Sachs interview
 */
public class Solution {

    public static class Interval {
        int startTime;
        int endTime;
        int price;
        public Interval(int startTime, int endTime, int price) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.price = price;
        }
        @Override
        public String toString() {
            return startTime+"/"+endTime+"/"+price;
        }
    }

    public List<Interval> findLowestIntervals(List<Interval> vendors) {

        List<Interval> toReturn = new ArrayList<>();

        //sort based on price
        List<Interval>  sorted = vendors
                .stream()
                .sorted((a, b) -> new Integer(a.price).compareTo(new Integer(b.price)))
                .collect(Collectors.toList());

        int earliest=Integer.MAX_VALUE;
        int latest=-1;

        Map<Integer,Integer> hourAndPrice = new HashMap<>();
        for(Interval interval : sorted) {
            for(int i=interval.startTime; i<=interval.endTime; i++) {
                if(interval.startTime < earliest) {
                    earliest=interval.startTime;
                }
                if(interval.endTime > latest) {
                    latest=interval.endTime;
                }

                //We never overwrite as we know that we will have previously encountered a cheaper price as we are
                //iterating over sorted (by price) intervals
                if(hourAndPrice.get(i) == null) {
                    hourAndPrice.put(i,interval.price);
                }
            }
        }

        System.out.println(hourAndPrice);

        //Sort by hour
        List<Integer> hours = hourAndPrice.keySet()
                .stream()
                .sorted((a, b) -> a.compareTo(b))
                .collect(Collectors.toList());

        earliest=hours.get(0);

        latest=hours.get(hours.size()-1);
        int currentPrice=hourAndPrice.get(hours.get(0));

        int currentStart = hours.get(0);
        for(int i=earliest; i<=latest; i++) {
            Integer price = hourAndPrice.get(i);

            if(price != currentPrice) {
                toReturn.add(new Interval(currentStart,i-1,currentPrice));
                currentPrice=hourAndPrice.get(i);
                currentStart=i;
            }
        }

        toReturn.add(new Interval(currentStart,latest,currentPrice));
        System.out.println(toReturn);
        return toReturn;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,10,200));
        intervals.add(new Interval(3,5,100));
        new Solution().findLowestIntervals(intervals);
    }

}
