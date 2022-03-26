package edu.ntnu.idatt2001.trym.cardgame.backend;

import java.util.List;

/**
 * This class outlines the information and methods that are intrinsic to a hand of cards. Therefore, the hand of cards
 * has been represented using an arrayList of PlayingCards.
 */
public class HandOfCards {
    private List<PlayingCard> handOfCards;

    public HandOfCards(List<PlayingCard> handOfCards) {
        this.handOfCards = handOfCards;
    }
}