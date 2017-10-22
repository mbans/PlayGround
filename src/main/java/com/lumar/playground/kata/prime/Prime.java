package com.lumar.playground.kata.prime;

import java.util.ArrayList;
import java.util.List;

public class Prime {

    public static List<Integer> of(int n) {
        List<Integer> toReturn = list();

        if(n==0 || n==1) {
            return list();
        }

        for(int i=2; i<=n; i++) {
            while (n % i == 0) {
                toReturn.add(i);
                n = n / i;
            }
        }

        return toReturn;
    }


    private static List<Integer> list(int... primes) {
        List<Integer> toReturn = new ArrayList<>();
        for(Integer prime : primes) {
            toReturn.add(prime);
        }
        return toReturn;
    }

}
