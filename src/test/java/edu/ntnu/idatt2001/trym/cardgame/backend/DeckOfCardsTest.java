package edu.ntnu.idatt2001.trym.cardgame.backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    @Nested
    public class Constructor_creates{

        @Test
        void an_object_without_throwing_exceptions(){
            //Arrange
            DeckOfCards deckOfCards = null;
            //Act
            try {
                deckOfCards = new DeckOfCards();
            } catch (Exception e) {
                fail("Preset constructor did not instantiate properly");
            }
        }

        @Test
        void a_deck_of_52_cards_with_13_face_and_4_suit(){
            //Arrange
            List<PlayingCard> expected52Deck = new ArrayList<>();
            for(int i = 1; i < 14; i++){
                expected52Deck.add(new PlayingCard('S', i));
                expected52Deck.add(new PlayingCard('H', i));
                expected52Deck.add(new PlayingCard('D', i));
                expected52Deck.add(new PlayingCard('C', i));

            }
            //Act
            DeckOfCards deckOfCards = new DeckOfCards();
            List<PlayingCard> actualDeckOfCards = deckOfCards.getDeckOfCards();

            //Assert
            for(PlayingCard playingCard : expected52Deck){
                if(actualDeckOfCards.stream().noneMatch(actualDeckCard ->
                        actualDeckCard.getFace() == playingCard.getFace()
                                && actualDeckCard.getSuit() == playingCard.getSuit())){
                    fail("Deck is not constructed correctly");
                }
            }
            assertTrue(true);
        }
    }

}