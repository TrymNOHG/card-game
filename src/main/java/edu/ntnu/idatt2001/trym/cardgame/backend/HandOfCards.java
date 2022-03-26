package edu.ntnu.idatt2001.trym.cardgame.backend;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class outlines the information and methods that are intrinsic to a hand of cards. Therefore, the hand of cards
 * has been represented using an arrayList of PlayingCards.
 */
public class HandOfCards {
    private List<PlayingCard> handOfCards;

    public HandOfCards(List<PlayingCard> handOfCards) {
        this.handOfCards = handOfCards;
    }


    public int sumFaceValueOfHand(){
        return this.handOfCards.stream().map(playingCard -> playingCard.getFace())
                .reduce(0, Integer::sum);
    }

}


//TODO: create a button to see if queen of spades exists on the hand