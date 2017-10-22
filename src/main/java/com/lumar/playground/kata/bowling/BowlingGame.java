package com.lumar.playground.kata.bowling;


/**
 * Simulate a bowling game.
 * Rules are
 * 1. 10 frames, with 2 throws per frame
 * 2. Strike is 10 skittles on one throw.
 *    For a strike in throw 'n' score for that frame will be 10+'throw n+1' + 'throw n+2'
 * 3. Half Strike is when 2 throws in frame = 10
 *    Score for that frame will be 10 + 'throw n+1'
 */
public class BowlingGame {


    private Integer score=0;

    public void roll(int pinsDown) {
        score += pinsDown;
    }

    public Integer score() {
        return score;
    }

}
