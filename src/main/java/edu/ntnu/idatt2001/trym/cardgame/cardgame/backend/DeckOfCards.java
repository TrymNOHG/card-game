package edu.ntnu.idatt2001.trym.cardgame.cardgame.backend;

import java.util.stream.IntStream;

public class DeckOfCards {
    private PlayingCard[] deckOfCards;
    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private final int numOfFaces = 13;

    public DeckOfCards() {
        //Potentially add a status variable in PlayingCard to know if it is in the deck: boolean inDeck or something
        this.deckOfCards = new PlayingCard[52];

        /*
        An int stream which goes through all indices of the deckOfCards array and inserts all the combinations of
        faces and suits
        */
        IntStream.range(0, this.deckOfCards.length).forEach(i -> this.deckOfCards[i] = new PlayingCard(suit[i % suit.length], (i % numOfFaces) + 1));


//        for(int i = 1; i <= numOfFaces; i++) {
//            for (int j = 1; j <= suit.length; j++) {
//                this.deckOfCards[i * j] = new PlayingCard(suit[j], i);
//            }
//        }

    }
}
