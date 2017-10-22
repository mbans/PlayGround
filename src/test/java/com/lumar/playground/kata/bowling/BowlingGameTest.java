package com.lumar.playground.kata.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void setUp() {
        this.game = new BowlingGame();
    }


    @Test
    public void canRollBall() {
        game.roll(0);
    }

    @Test
    public void canScoreGameOfZeros() {
        BowlingGame game = new BowlingGame();
        roll(20, 1);
        assertThat(game.score(), is(20));
    }


    private void roll(int numberOfRolls, int score) {
        for(int i=0; i<numberOfRolls; i++) {
            game.roll(score);
        }
    }
}
