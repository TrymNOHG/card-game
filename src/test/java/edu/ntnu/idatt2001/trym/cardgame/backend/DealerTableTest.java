package edu.ntnu.idatt2001.trym.cardgame.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DealerTableTest {

    @Test
    void if_more_cards_than_deck_size_are_wanted_then_throws_exception() {
        //Arrange
        int deckSize = 52;
        int moreThanDeckSize = deckSize + 1;
        DealerTable dealerTable = new DealerTable();

        assertThrows(IllegalArgumentException.class,() ->{
            //Act
            dealerTable.dealHand(moreThanDeckSize);
        }); //Assert
    }

    @Test
    void constructor_does_not_throw_exception(){
        //Arrange
        DealerTable dealerTable = null;

        //Act
        try {
            dealerTable = new DealerTable();
        } catch (Exception e) {
            fail("Preset constructor did not instantiate properly");
        }

        //Assert
        assertTrue(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 52}) //Arrange
    void the_same_amount_of_cards_is_dealt_as_sent_in(int handSize){
        DealerTable dealerTable = new DealerTable();

        //Act
        dealerTable.dealHand(handSize);

        //Assert
        Assertions.assertEquals(handSize, dealerTable.getCurrentHandList().get(0).getHandOfCards().size());
    }

    @Test
    void if_cards_are_dealt_the_limit_of_hand_size_decreases() {
        //Arrange
        int initialHandSize = 52;
        DealerTable dealerTable = new DealerTable();
        int firstDealSize = 1;
        int expectedLimitOnNextDeal = 51;

        //Act
        dealerTable.dealHand(firstDealSize);

        //Assert
        assertThrows(IllegalArgumentException.class, () -> {
            dealerTable.dealHand(initialHandSize);
        });
        assertEquals(expectedLimitOnNextDeal, dealerTable.getTableDeck().getDeckOfCards().size());
    }

}