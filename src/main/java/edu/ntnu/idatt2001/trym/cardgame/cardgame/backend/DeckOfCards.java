package edu.ntnu.idatt2001.trym.cardgame.cardgame.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * This class creates the structure of a deck of cards. Since a deck of cards doesn't necessarily have a fixed size
 * (although it does start with 52 cards), it can have cards removed when dealt. Therefore, instead of choosing
 * a fixed array, an arrayList allows for greater versatility in representing a deck of cards.
 */
public class DeckOfCards {
    private List<PlayingCard> deckOfCards;
    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private final int numOfFaces = 13;
    private final int maxSizeOfDeck = suit.length * numOfFaces;

    public DeckOfCards() {
        //Initializing deckOfCards with a starting capacity of 52;
        this.deckOfCards = new ArrayList<>(maxSizeOfDeck);

        /*
        An int stream which goes through all indices of the deckOfCards arrayList and inserts all the combinations of
        faces and suits
        */
        IntStream.range(0, maxSizeOfDeck).forEach(i -> this.deckOfCards.set(i, new PlayingCard(suit[i % suit.length], (i % numOfFaces) + 1)));

    }

    public List<PlayingCard> getDeckOfCards() {
        return deckOfCards;
    }
}

//TODO: Add unit test for the stream and constructor.