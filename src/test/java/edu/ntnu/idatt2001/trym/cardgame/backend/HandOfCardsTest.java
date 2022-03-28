package edu.ntnu.idatt2001.trym.cardgame.backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandOfCardsTest {

    @Test
    void if_sum_of_hand_is_correct() {
        //Arrange
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard('S', 5));
        hand.add(new PlayingCard('S', 13));
        int expectedSumOfHand = 18;
        HandOfCards handOfCards = new HandOfCards(hand);

        //Act
        int actualSumOfHand = handOfCards.sumFaceValueOfHand();

        //Assert
        assertEquals(expectedSumOfHand, actualSumOfHand);
    }

    @Test
    void if_hand_is_properly_filtered() {
        //Arrange
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard('S', 5));
        hand.add(new PlayingCard('S', 13));
        hand.add(new PlayingCard('D', 1));
        hand.add(new PlayingCard('C', 10));
        HandOfCards handOfCards = new HandOfCards(hand);

        List<PlayingCard> expectedFilteredList = new ArrayList<>();
        expectedFilteredList.add(new PlayingCard('S', 5));
        expectedFilteredList.add(new PlayingCard('S', 13));

        //Act
        List<PlayingCard> actualFilteredList = handOfCards.filterHandBySuit('S');

        //Assert
        for(int i = 0; i < actualFilteredList.size(); i++){
            assertEquals(expectedFilteredList.get(i).getSuit(), actualFilteredList.get(i).getSuit());
        }
    }

    @ParameterizedTest
    @CsvSource({"S,13", "H, 5", "D, 1", "C, 10"}) //Act
    void check_if_card_is_on_hand(char suit, int face) {
        List<PlayingCard> cardsOnHand = new ArrayList<>();
        cardsOnHand.add(new PlayingCard(suit, face));
        cardsOnHand.add(new PlayingCard('S', 11));
        cardsOnHand.add(new PlayingCard('D', 12));
        cardsOnHand.add(new PlayingCard('C', 9));
        HandOfCards handOfCards = new HandOfCards(cardsOnHand);
        boolean expectedStatus = true;

        //Act
        boolean actualStatus = handOfCards.doesCardExistOnHand(suit, face);

        //Assert
        assertEquals(expectedStatus, actualStatus);
    }

    @ParameterizedTest
    @CsvSource({"S,13", "H, 5", "D, 1", "C, 10"}) //Act
    void check_if_card_is_not_on_hand(char suit, int face) {
        List<PlayingCard> cardsOnHand = new ArrayList<>();
        cardsOnHand.add(new PlayingCard('S', 11));
        cardsOnHand.add(new PlayingCard('D', 12));
        cardsOnHand.add(new PlayingCard('C', 9));
        HandOfCards handOfCards = new HandOfCards(cardsOnHand);
        boolean expectedStatus = false;

        //Act
        boolean actualStatus = handOfCards.doesCardExistOnHand(suit, face);

        //Assert
        assertEquals(expectedStatus, actualStatus);
    }

    @ParameterizedTest
    @ValueSource (strings = {"S", "H", "D", "C"})
    void if_hand_is_flush(char suit) {
        List<PlayingCard> cardsOnHand = new ArrayList<>();
        for(int i = 1; i < 6; i++){
            cardsOnHand.add(new PlayingCard(suit, i*2));
        }

        HandOfCards handOfCards = new HandOfCards(cardsOnHand);

        boolean expectedStatus = true;

        //Act
        boolean actualStatus = handOfCards.checkForFlush();

        //Assert
        assertEquals(expectedStatus, actualStatus);
    }

    @ParameterizedTest
    @ValueSource (strings = {"S", "H", "D", "C"})
    void if_hand_is_not_flush(char suit) {
        List<PlayingCard> cardsOnHand = new ArrayList<>();
        for(int i = 1; i < 4; i++){
            cardsOnHand.add(new PlayingCard(suit, i*2));
        }
        cardsOnHand.add(new PlayingCard('C', 4));
        cardsOnHand.add(new PlayingCard('S', 5));

        HandOfCards handOfCards = new HandOfCards(cardsOnHand);

        boolean expectedStatus = false;

        //Act
        boolean actualStatus = handOfCards.checkForFlush();

        //Assert
        assertEquals(expectedStatus, actualStatus);
    }

}