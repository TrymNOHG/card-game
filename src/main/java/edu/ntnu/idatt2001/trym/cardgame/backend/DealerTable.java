package edu.ntnu.idatt2001.trym.cardgame.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * This class represents a dealer table, where a card game is currently being held. It, therefore, contains information
 * on the table's deck of cards and all the hands currently held.
 */
public class DealerTable {
    private DeckOfCards tableDeck;
    private List<HandOfCards> currentHandList;
    Random random = new Random();

    public DealerTable() {
        newTable();
    }

    /**
     * This method deals a hand of size n, as long as there are an n-number of cards left in the deck. If n is
     * an invalid number, smaller than 1 or more than the deck size, then an IllegalArgumentException is thrown.
     * @param n Number of cards desired, represented as an int
     */
    public void dealHand(int n){
        List<PlayingCard> hand = new ArrayList<>();
        if(n < 1 || n > this.tableDeck.getDeckOfCards().size()) throw new IllegalArgumentException("The hand size is invalid!");

//        for(int i = 0; i < n; i++){
//            int randomNum = random.nextInt(this.tableDeck.getDeckOfCards().size());
//            hand.add(this.tableDeck.getDeckOfCards().get(randomNum));
//            this.tableDeck.getDeckOfCards().remove(randomNum);
//        }

        IntStream.range(0, n).forEach(i -> {
            int randomNum = random.nextInt(this.tableDeck.getDeckOfCards().size());
            hand.add(this.tableDeck.getDeckOfCards().get(randomNum));
            this.tableDeck.getDeckOfCards().remove(randomNum);
        });

        this.currentHandList.add(new HandOfCards(hand));
    }
    //TODO: add unit test for this method and constructor.

    /**
     * This method resets the deck of cards with 52 PlayCard and starts a new list for currentHand.
     */
    public void newTable(){
        this.tableDeck = new DeckOfCards();
        this.currentHandList = new ArrayList<>();
    }

    /**
     * This method retrieves the current deckOfCards
     * @return Deck Of Cards, represented as a list of PlayingCards
     */
    public DeckOfCards getTableDeck() {
        return tableDeck;
    }

    /**
     * This method retrieves a list of all the hands around the table currently.
     * @return A list of all the hands around the table, represented as a list of HandOfCards
     */
    public List<HandOfCards> getCurrentHandList() {
        return currentHandList;
    }
}
