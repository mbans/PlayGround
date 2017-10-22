package com.lumar.playground.kata.prime;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrimeTest {

    @Test
    public void of0is0() {
        assertThat(Prime.of(0), is(list()));
    }

    @Test
    public void of1isEmpty() {
        assertThat(Prime.of(1), is(list()));
    }

    @Test
    public void of2is2() {
        assertThat(Prime.of(2), is(list(2)));
    }

    @Test
    public void of3is3() {
        assertThat(Prime.of(3), is(list(3)));
    }

    @Test
    public void of5is5() {
        assertThat(Prime.of(5), is(list(5)));
    }

    @Test
    public void of9is3and3() {
        assertThat(Prime.of(9), is(list(3,3)));
    }

    @Test
    public void of8is2and2and2() {
        assertThat(Prime.of(8), is(list(2,2,2)));
    }

    @Test
    public void of11() {
        assertThat(Prime.of(11), is(list(11)));
    }

    @Test
    public void of120120() {
        assertThat(Prime.of(120120), is(list(2,2,2,3,5,7,11,13)));
    }



    private List<Integer> list(Integer... content) {
        List<Integer> toReturn = new ArrayList<Integer>();
        for(Integer n : content) {
            toReturn.add(n);
        }
        return toReturn;
    }

}
